package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.common.enums.RoleEnum;
import com.grainoil.common.enums.StoreTypeEnum;
import com.grainoil.common.exception.BusinessException;
import com.grainoil.system.domain.TbGrainDepot;
import com.grainoil.system.domain.TbOrganize;
import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.domain.vo.common.SecondNode;
import com.grainoil.system.domain.vo.common.ThirdNode;
import com.grainoil.system.domain.vo.point_management.*;
import com.grainoil.system.mapper.*;
import com.grainoil.system.service.ITbGrainDepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TbGrainDepotServiceImpl implements ITbGrainDepotService {

    @Autowired
    TbGrainDepotMapper tbGrainDepotMapper;

    @Autowired
    TbCompanyStorageMapper companyStorageMapper;

    @Autowired
    TbOrganizeMapper organizeMapper;

    @Autowired
    TbUserMapper userMapper;

    @Autowired
    TbManStorageMapper manStorageMapper;

    @Autowired
    TbGrainActualInventoryMapper grainActualInventoryMapper;

    /**
     * 添加粮库信息
     *
     * @param depot 粮库信息
     * @return 结果
     */
    @Override
    public ResponseResult insert(GrainDepotInsert depot, CurrentUser currentUser) {
        Map<String, Object> map = verify(depot);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        int insert = tbGrainDepotMapper.insert(depot, currentUser);
        return insert > 0 ? ResponseResult.success() : ResponseResult.error();
    }

    /**
     * 根据条件查询粮库信息集合
     *
     * @param depot 粮库信息
     * @param organizeId 当前用户所属市区组织id
     * @return 粮库信息集合
     */
    @Override
    public ResponseResult<List<GrainDepotListVo>> list(GrainDepotQueryVo depot, Long organizeId, String organizeType) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            List<GrainDepotListVo> list = tbGrainDepotMapper.select(depot, null);
            return ResponseResult.success(list);
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            List<GrainDepotListVo> list = tbGrainDepotMapper.select(depot, organizeId);
            return ResponseResult.success(list);
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            List<GrainDepotListVo> list = tbGrainDepotMapper.list(depot, organizeId);
            return ResponseResult.success(list);
        } else {
            return ResponseResult.error("数据库数据异常");
        }
    }

    /**
     * 修改粮库信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult update(GrainDepotUpdate depot, CurrentUser currentUser, Long organizeId, String organizeType) {
        TbGrainDepot tbGrainDepot1 = tbGrainDepotMapper.selectByPrimaryKey(depot.getGrainDepotId());
        if (tbGrainDepot1 == null) {
            return ResponseResult.error("粮库不存在");
        }
        if (!"0".equals(tbGrainDepot1.getGrainDepotState())) {
            return ResponseResult.error("停用的粮库不能修改");
        }
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            Map<String, Object> verify = verifyUpdate(depot);
            if (verify.get("success").equals(false)) {
                return ResponseResult.error(verify.get("msg") + "");
            }
            int i = tbGrainDepotMapper.updateByPrimaryKey(depot, currentUser);
            return i > 0 ? ResponseResult.success() : ResponseResult.error();
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            if (organizeId.equals(tbGrainDepot1.getCenterId())) {
                Map<String, Object> verify = verifyUpdate(depot);
                if (verify.get("success").equals(false)) {
                    return ResponseResult.error(verify.get("msg") + "");
                }
                int i = tbGrainDepotMapper.updateByPrimaryKey(depot, currentUser);
                return i > 0 ? ResponseResult.success() : ResponseResult.error();
            } else {
                return ResponseResult.error("无修改该粮库信息的权限");
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            Integer num = companyStorageMapper.checkGrainDepotUse(depot.getGrainDepotId(), organizeId);
            if (organizeId.equals(tbGrainDepot1.getBelongId()) || num != 0) {
                if (organizeId.equals(tbGrainDepot1.getBelongId())) {
                    tbGrainDepotMapper.update(depot, currentUser);
                }
                if (num != 0) {
                    if (depot.getPersonId() == null || depot.getPersonId().size() == 0) {
                        throw new BusinessException("粮库负责人参数错误或者没有选择粮库负责人");
                    }
                    List<Long> userIds = userMapper.getUserIds(organizeId, Long.parseLong(RoleEnum.COMPANY_GRAINDEPOT_PRINCIPAL.getCode()));
                    manStorageMapper.delete(userIds, depot.getGrainDepotId(), StoreTypeEnum.GRAINDEPOT.getCode(), currentUser);
                    Integer integer = userMapper.checkUserIds(organizeId, Long.parseLong(RoleEnum.COMPANY_GRAINDEPOT_PRINCIPAL.getCode()), depot.getPersonId());
                    if (depot.getPersonId().size() != integer) {
                        throw new BusinessException("粮库负责人参数错误");
                    } else {
                        manStorageMapper.batchInsert(depot.getPersonId(), depot.getGrainDepotId(), StoreTypeEnum.GRAINDEPOT.getCode(), currentUser);
                    }
                }
                return ResponseResult.success();
            } else {
                return ResponseResult.error("无修改该粮库信息的权限");
            }
        } else {
            return ResponseResult.error("数据库数据异常");
        }
    }

    /**
     * 获取修改时的粮库信息
     *
     * @param grainDepotId 粮库id
     * @return 结果
     */
    @Override
    public ResponseResult<GrainDepotGet> getUpdate(Long grainDepotId, Long organizeId, String organizeType) {
        TbGrainDepot tbGrainDepot = tbGrainDepotMapper.selectByPrimaryKey(grainDepotId);
        if (tbGrainDepot == null) {
            return ResponseResult.error("获取粮库信息失败");
        }
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType)) {
            GrainDepotGet grainDepot2 = tbGrainDepot.getGrainDepot();
            grainDepot2.setCenterName(organizeMapper.selectByPrimaryKey(grainDepot2.getCenterId()).getOrganizeName());
            return ResponseResult.success(grainDepot2);
        } else if (OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            if (organizeId.equals(tbGrainDepot.getCenterId())) {
                GrainDepotGet grainDepot2 = tbGrainDepot.getGrainDepot();
                grainDepot2.setCenterName(organizeMapper.selectByPrimaryKey(grainDepot2.getCenterId()).getOrganizeName());
                return ResponseResult.success(grainDepot2);
            } else {
                return ResponseResult.error("无查询该粮库信息的权限");
            }
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            Integer num = companyStorageMapper.checkGrainDepotUse(grainDepotId, organizeId);
            if (organizeId.equals(tbGrainDepot.getBelongId()) || num != 0) {
                GrainDepotGet grainDepot2 = tbGrainDepot.getGrainDepot();
                grainDepot2.setCenterName(organizeMapper.selectByPrimaryKey(grainDepot2.getCenterId()).getOrganizeName());
                // 使用企业信息
                List<OrganizeVo> list = companyStorageMapper.getUseCompanies(grainDepotId);
                if (num != 0) {
                    // 使用企业对应的粮库负责人下拉框
                    List<Map<String, Object>> userList = userMapper.findGrainDepot(organizeId);
                    for (OrganizeVo vo : list) {
                        if (organizeId.equals(vo.getOrganizeId())) {
                            vo.setUserList(userList);
                            break;
                        }
                    }
                }
                grainDepot2.setOrganizeVoList(list);
                return ResponseResult.success(grainDepot2);
            } else {
                return ResponseResult.error("无查询该粮库信息的权限");
            }
        } else {
            return ResponseResult.error("数据库数据异常");
        }
    }

    /**
     * 获取所有的粮库下拉框
     *
     * @return 粮库下拉框
     */
    @Override
    public List<Map<String, Object>> getGrainDepots() {
        return tbGrainDepotMapper.getGrainDepots();
    }

    /**
     * 添加存储合同添加明细表的添加按钮
     *
     * @param id 粮库id
     * @return 数据列表
     */
    @Override
    public List<Map<String, Object>> getStorageDetailList(Long id) {
        return tbGrainDepotMapper.getStorageDetailList(id);
    }

    /**
     * 获取列表查询条件粮库下拉框
     *
     * @return
     */
    @Override
    public List<LeafNode> getGrainDepotList(Long organizeId, String organizeType) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType) || OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            return grainActualInventoryMapper.getOrganizeList(organizeId);
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            return grainActualInventoryMapper.getCompanyList(organizeId);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 获取粮库仓房联动下拉框
     *
     * @param organizeId
     * @param organizeType
     * @return
     */
    @Override
    public List<SecondNode> getSecondNode(Long organizeId, String organizeType) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType) || OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            return grainActualInventoryMapper.getOrganizeList2(organizeId);
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            return grainActualInventoryMapper.getCompanyList2(organizeId);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 获取粮库-仓房-堆位联动下拉框
     *
     * @param organizeId
     * @param organizeType
     * @return
     */
    @Override
    public List<ThirdNode> getThirdNode(Long organizeId, String organizeType) {
        if (OrganizeTypeEnum.CITY.getCode().equals(organizeType) || OrganizeTypeEnum.REGION.getCode().equals(organizeType)) {
            return grainActualInventoryMapper.getOrganizeList3(organizeId);
        } else if (OrganizeTypeEnum.COMPANY.getCode().equals(organizeType)) {
            return grainActualInventoryMapper.getCompanyList3(organizeId);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 添加时验证粮库信息是否正确
     *
     * @param depot 粮库信息
     * @return 结果
     */
    private Map<String, Object> verify(GrainDepotInsert depot) {
        Integer num = tbGrainDepotMapper.count(depot);
        if (num > 0) {
            return BaseMap.getFailureMap("粮库名称或者粮库编码已存在");
        }
        TbOrganize select = organizeMapper.select(depot.getCenterId(), OrganizeTypeEnum.REGION.getCode());
        if (select == null) {
            return BaseMap.getFailureMap("上级管理组织不存在或者已经停用");
        }
        TbOrganize tbOrganize = organizeMapper.select(depot.getBelongId(), OrganizeTypeEnum.COMPANY.getCode());
        if (tbOrganize == null) {
            return BaseMap.getFailureMap("企业不存在或者已经停用");
        }
        depot.setBelongName(tbOrganize.getOrganizeName());
        return BaseMap.getSuccessMap();
    }

    /**
     * 修改时验证粮库信息是否正确
     *
     * @param depot 粮库信息
     * @return 结果
     */
    private Map<String, Object> verifyUpdate(GrainDepotUpdate depot) {
        Integer num = tbGrainDepotMapper.countUpdate(depot);
        if (num > 0) {
            return BaseMap.getFailureMap("粮库名称或者粮库编码已存在");
        }
        TbOrganize select = organizeMapper.select(depot.getCenterId(), OrganizeTypeEnum.REGION.getCode());
        if (select == null) {
            return BaseMap.getFailureMap("上级管理组织不存在或者已经停用");
        }
        TbOrganize tbOrganize = organizeMapper.select(depot.getBelongId(), OrganizeTypeEnum.COMPANY.getCode());
        if (tbOrganize == null) {
            return BaseMap.getFailureMap("企业不存在或者已经停用");
        }
        depot.setBelongName(tbOrganize.getOrganizeName());
        return BaseMap.getSuccessMap();
    }
}
