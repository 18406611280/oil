package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.exception.BusinessException;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.*;
import com.grainoil.system.domain.vo.storage_contract.StorageContractDetailedVo;
import com.grainoil.system.domain.vo.storage_contract.StorageContractVo;
import com.grainoil.system.mapper.*;
import com.grainoil.system.service.ITbStorageContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TbStorageContractServiceImpl implements ITbStorageContractService {

    @Autowired
    TbStorageContractMapper storageContractMapper;

    @Autowired
    TbStorageContractDetailedMapper detailedMapper;

    @Autowired
    TbGrainDepotMapper grainDepotMapper;

    @Autowired
    TbVarietyMapper varietyMapper;

    @Autowired
    TbOrganizeMapper organizeMapper;

    @Autowired
    TbCompanyStorageMapper companyStorageMapper;

    /**
     * 插入存储合同以及明细
     *
     * @param storageContract 存储合同信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult insert(StorageContractVo storageContract, CurrentUser currentUser) {
        Map<String, Object> map = verify(storageContract, false);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        StorageContractVo contract = analyze(storageContract, currentUser.getOrganizeId());
        if (contract == null) {
            return ResponseResult.error("组织信息错误");
        }
        storageContractMapper.insert(contract, currentUser);
        List<StorageContractDetailedVo> list = analyze2(contract, currentUser.getOrganizeType());
        if (list == null) {
            throw new BusinessException("组织类型错误");
        }
        detailedMapper.batchInsert(list);
        List<Long> ids = companyStorageMapper.getGrainDepotIds(contract.getOrganizeId());
        // 需要添加的粮库id集合
        List<Long> longs = new ArrayList<>();
        for (StorageContractDetailedVo storageContractDetailedVo : list) {
            boolean flag = false;
            for (Long id : ids) {
                if (storageContractDetailedVo.getGrainDepotId().equals(id)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                longs.add(storageContractDetailedVo.getGrainDepotId());
            }
        }
        if (longs.size() > 0) {
            companyStorageMapper.insertGrainDepot2(contract.getOrganizeId(), longs, currentUser);
        }
        return ResponseResult.success();
    }

    /**
     * 根据条件查询存储合同列表数据
     *
     * @param map 查询列表条件
     * @return 列表数据
     */
    @Override
    public List<Map<String, Object>> list(Map<String, Object> map, String organizeType, Long organizeId) {
        if ("1".equals(organizeType) || "2".equals(organizeType)) {
            return storageContractMapper.list(map, organizeId);
        } else if ("5".equals(organizeType)) {
            return storageContractMapper.list2(map, organizeId);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 根据id查询合同信息
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R get(Long id) {
        TbStorageContractDetailed detailed = detailedMapper.selectByPrimaryKey(id);
        if (detailed == null) {
            return R.error("获取合同明细表信息失败");
        }
        TbStorageContract contract = storageContractMapper.selectByPrimaryKey(detailed.getStroageContractId());
        if (contract == null) {
            return R.error("获取合同信息失败");
        }
        return R.data(contract);
    }

    /**
     * 完善存储合同信息
     *
     * @param storageContract 存储合同
     * @return 完善后的存储合同
     */
    public StorageContractVo analyze(StorageContractVo storageContract, Long oragnizeId) {
        TbOrganize tbOrganize = organizeMapper.selectByPrimaryKey(oragnizeId);
        // 粮权所属市或者区组织不存在或者已停用
        if (tbOrganize == null) {
            return null;
        }
        storageContract.setGrainOwnerId(oragnizeId);
        storageContract.setGrainOwnerName(tbOrganize.getOrganizeName());
        TbOrganize tbOrganize1 = organizeMapper.selectByPrimaryKey(storageContract.getOrganizeId());
        // 承储企业不存在或者已停用
        if (tbOrganize1 == null) {
            return null;
        }
        storageContract.setOrganizeName(tbOrganize1.getOrganizeName());
        return storageContract;
    }

    /**
     * 完善存储合同明细集合
     *
     * @param storageContract 存储合同
     * @return 完善后的存储合同明细集合
     */
    public List<StorageContractDetailedVo> analyze2(StorageContractVo storageContract, String organizeType) {
        List<StorageContractDetailedVo> detailedList = storageContract.getDetailedList();
        if ("1".equals(organizeType)) {
            Set<Long> ids = new HashSet<>();
            for (StorageContractDetailedVo detailed : detailedList) {
                detailed.setStroageContractId(storageContract.getId());
                ids.add(detailed.getGrainDepotId());
            }
            List<Map<String, Object>> map = grainDepotMapper.getContractRelation(ids);
            for (StorageContractDetailedVo detailed : detailedList) {
                for (Map<String, Object> stringObjectMap : map) {
                    if (detailed.getGrainDepotId().equals(Long.parseLong(stringObjectMap.get("grain_depot_id") + ""))) {
                        detailed.setGrainRegionId(Long.parseLong(stringObjectMap.get("organize_id") + ""));
                        detailed.setGrainRegionName(stringObjectMap.get("organize_name") + "");
                        break;
                    }
                }
            }
        } else if ("2".equals(organizeType)) {
            for (StorageContractDetailedVo detailed : detailedList) {
                detailed.setStroageContractId(storageContract.getId());
                detailed.setGrainRegionId(storageContract.getGrainOwnerId());
                detailed.setGrainRegionName(storageContract.getGrainOwnerName());
            }
        } else {
            return null;
        }
        return detailedList;
    }

    /**
     * 验证存储合同的数据是否正确
     *
     * @param storageContract 存储合同信息
     * @param b 添加/修改
     * @return 结果
     */
    public Map<String, Object> verify(StorageContractVo storageContract, boolean b) {
        List<StorageContractDetailedVo> detailedList = storageContract.getDetailedList();
        // 验证数据是否重复
        Set<String> set = new HashSet<>();
        // 验证数据是否错误
        Set<Long> gSet = new HashSet<>();
        Set<Long> vSet = new HashSet<>();
        for (StorageContractDetailedVo detailed : detailedList) {
            if (detailed.getQuantity() <= 0 || detailed.getPrice() <= 0) {
                return BaseMap.getFailureMap("数据错误");
            }
            set.add(detailed.getGrainDepotId() + " " + detailed.getVarietyId());
            gSet.add(detailed.getGrainDepotId());
            vSet.add(detailed.getVarietyId());
        }
        if (set.size() != detailedList.size()) {
            return BaseMap.getFailureMap("数据重复");
        }
        List<TbGrainDepot> list = grainDepotMapper.checkContract(gSet);
        if (list.size() != gSet.size()) {
            return BaseMap.getFailureMap("粮库信息错误");
        }
        List<TbVariety> list1 = varietyMapper.checkContract(vSet);
        if (list1.size() != vSet.size()) {
            return BaseMap.getFailureMap("粮油品种信息错误");
        }
        for (StorageContractDetailedVo detailed : detailedList) {
            for (TbGrainDepot tbGrainDepot : list) {
                if (tbGrainDepot.getGrainDepotId().equals(detailed.getGrainDepotId())) {
                    detailed.setGrainDepotName(tbGrainDepot.getGrainDepotName());
                    break;
                }
            }
            for (TbVariety tbVariety : list1) {
                if (tbVariety.getVarietyId().equals(detailed.getVarietyId())) {
                    detailed.setVariety(tbVariety.getVarietyName());
                    break;
                }
            }
        }
        return BaseMap.getSuccessMap();
    }
}
