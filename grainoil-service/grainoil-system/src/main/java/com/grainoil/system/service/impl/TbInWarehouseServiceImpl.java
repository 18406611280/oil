package com.grainoil.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.*;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbInWarehouse;
import com.grainoil.system.domain.vo.FileVo;
import com.grainoil.system.domain.vo.in_warehouse.*;
import com.grainoil.system.mapper.*;
import com.grainoil.system.service.ITbInWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class TbInWarehouseServiceImpl implements ITbInWarehouseService {

    @Autowired
    TbInWarehouseMapper inWarehouseMapper;

    @Autowired
    TbInWarehouseDetailedMapper inWarehouseDetailedMapper;

    @Autowired
    TbGrainDepotMapper grainDepotMapper;

    @Autowired
    TbStorehouseMapper storehouseMapper;

    @Autowired
    TbPileMapper pileMapper;

    @Autowired
    TbVarietyMapper varietyMapper;

    @Autowired
    TbStorageContractMapper storageContractMapper;

    @Autowired
    TbOrganizeMapper organizeMapper;

    @Autowired
    TbFileMapper fileMapper;

    @Autowired
    TbInWarehouseDetailedCheckMapper inWarehouseDetailedCheckMapper;

    @Autowired
    TbChildPileMapper childPileMapper;

    @Autowired
    TbGrainActualInventoryMapper grainActualInventoryMapper;

    /**
     * 添加入仓单
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @Override
    public R insert(TbInWarehouse inWarehouse) {
        Map<String, Object> map = verify(inWarehouse);
        if (map.get("success").equals(false)) {
            return R.error(map.get("msg") + "");
        }
        analyze(inWarehouse);
        int insert = inWarehouseMapper.insert(inWarehouse);
        return insert > 0 ? R.ok() : R.error();
    }

    /**
     * 完善入仓单信息
     *
     * @param inWarehouse 入仓单
     */
    private void analyze(TbInWarehouse inWarehouse) {
        inWarehouse.setGrainDepotName(grainDepotMapper.selectByPrimaryKey(inWarehouse.getGrainDepotId()).getGrainDepotName());
        inWarehouse.setVariety(varietyMapper.selectByPrimaryKey(inWarehouse.getVarietyId()).getVarietyName());
        inWarehouse.setStorehouseName(storehouseMapper.selectByPrimaryKey(inWarehouse.getStorehouseId()).getStorehouseName());
        // 根据入仓单类型获取批文编号
        inWarehouse.setBatchCode(storageContractMapper.selectByPrimaryKey(inWarehouse.getBatchId()).getContractCode());
        inWarehouse.setGrainOrganizeName(organizeMapper.selectByPrimaryKey(inWarehouse.getGrainOrganizeId()).getOrganizeName());
        if (inWarehouse.getOrganizeId() != null) {
            inWarehouse.setOrganizeName(organizeMapper.selectByPrimaryKey(inWarehouse.getOrganizeId()).getOrganizeName());
        }
    }

    /**
     * 根据id获取入仓单信息
     *
     * @param id 入仓单id
     * @return 入仓单信息
     */
    @Override
    public ResponseResult<InWarehouseVo> get(Long id) {
        TbInWarehouse tbInWarehouse = inWarehouseMapper.selectByPrimaryKey(id);
        if (tbInWarehouse == null) {
            return ResponseResult.error("获取入仓单信息失败");
        }
        String state = tbInWarehouse.getState();
        if (ImportStateEnum.DRAFT.getCode().equals(state) || ImportStateEnum.APPROVAL_PENDING.getCode().equals(state) || ImportStateEnum.NOT_GO.getCode().equals(state)) {
            return ResponseResult.success(tbInWarehouse.getInWarehouse());
        } else if (ImportStateEnum.COMPLETED.getCode().equals(state) || ImportStateEnum.RUNNING.getCode().equals(state)) {
            InWarehouseVo vo = getInWarehouseVo(tbInWarehouse);
            return ResponseResult.success(vo);
        } else {
            return ResponseResult.error("数据库数据错误");
        }
    }

    /**
     * 根据入仓单信息获取返回给前端的视图
     *
     * @param tbInWarehouse 入仓单信息
     * @return 视图信息
     */
    public InWarehouseVo getInWarehouseVo(TbInWarehouse tbInWarehouse) {
        InWarehouseVo inWarehouse = tbInWarehouse.getInWarehouse();
        List<InWarehouseDetailVo> list = inWarehouseDetailedMapper.get(tbInWarehouse.getId());
        BigDecimal bigDecimal = new BigDecimal(0);
        for (InWarehouseDetailVo detail : list) {
            if (StringUtils.isNotBlank(detail.getEnclosure())) {
                List<FileVo> fileVos = fileMapper.getFileVo(detail.getEnclosure().split(","));
                detail.setFileVos(fileVos);
            }
            if (AuditStateEnum.COMPLETE.getCode().equals(detail.getIsAudit())) {
                bigDecimal = bigDecimal.add(new BigDecimal(detail.getQuantity()));
            }
        }
        inWarehouse.setAlreadyQuantity(bigDecimal.doubleValue());
        inWarehouse.setPercent(bigDecimal.divide(new BigDecimal(inWarehouse.getQuantity()), 2).doubleValue());
        inWarehouse.setDetailed(list);
        return inWarehouse;
    }

    /**
     * 根据条件查询入仓单信息
     *
     * @param inWarehouse 入仓单条件
     * @return 入仓单列表
     */
    @Override
    public ResponseResult<PageView<InWarehouseListVo>> list(InWarehouseQuery inWarehouse, String organizeType, Long organizeId, Long lq) {
        PageHelper.startPage(inWarehouse.getCurrent(), inWarehouse.getPageSize());
        List<InWarehouseListVo> list = inWarehouseMapper.list(inWarehouse, organizeType, organizeId, lq);
        PageInfo<InWarehouseListVo> pageInfo = new PageInfo<>(list);
        return ResponseResult.success(new PageView<>(pageInfo));
    }

    /**
     * 根据入库类型获取批文编号
     *
     * @param type       入库类型(数字字典)
     * @param organizeId 企业id
     * @return 批文编号列表
     */
    @Override
    public R getBatchCode(String type, Long organizeId) {
        if (InWarehouseTypeEnum.CALL_FOR_BID.getCode().equals(type)) {
            return R.data(storageContractMapper.getBatchCode(organizeId));
        } else {
            return R.data(new ArrayList<>());
        }
    }

    /**
     * 根据批文编号id查询粮库,粮油品种,仓房的数据
     *
     * @param id 批文编号id
     * @return 结果
     */
    @Override
    public ResponseResult<List<DropDownVo>> getData(String type, Long id) {
        List<DropDownVo> data = new ArrayList<>();
        List<DropDownVo> data2 = new ArrayList<>();
        if (InWarehouseTypeEnum.CALL_FOR_BID.getCode().equals(type)) {
            data =  storageContractMapper.getData(id); // 粮库-粮油品种
            data2 = storageContractMapper.getData2(id); // 粮库-仓房
        } else if (InWarehouseTypeEnum.ROTATION.getCode().equals(type)) {

        } else if (InWarehouseTypeEnum.MOVING_THE_STOREHOUSE.getCode().equals(type)) {

        }
        for (DropDownVo datum : data) {
            for (DropDownVo dropDownVo : data2) {
                if (datum.getId().equals(dropDownVo.getId())) {
                    datum.setStorehouses(dropDownVo.getStorehouses());
                    break;
                }
            }
        }
        return ResponseResult.success(data);
    }

    /**
     * 更新入仓单信息
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @Override
    public R updateSave(TbInWarehouse inWarehouse) {
        TbInWarehouse tbInWarehouse = inWarehouseMapper.selectByPrimaryKey(inWarehouse.getId());
        if (tbInWarehouse == null) {
            return R.error("更新的入仓单不存在");
        }
        if (ImportStateEnum.DRAFT.getCode().equals(tbInWarehouse.getState()) || ImportStateEnum.NOT_GO.getCode().equals(tbInWarehouse.getState())) {
            Map<String, Object> verify = verify(inWarehouse);
            if (verify.get("success").equals(false)) {
                return R.error(verify.get("msg") + "");
            }
            analyze(inWarehouse);
            int i = inWarehouseMapper.updateByPrimaryKey(inWarehouse);
            return i > 0 ? R.ok() : R.error();
        } else {
            return R.error("该入仓单无法编辑");
        }
    }

    /**
     * 更新入仓单信息(提交)
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R updateSubmit(TbInWarehouse inWarehouse) {
        TbInWarehouse tbInWarehouse = inWarehouseMapper.selectByPrimaryKey(inWarehouse.getId());
        if (tbInWarehouse == null) {
            return R.error("更新的入仓通知单不存在");
        }
        if (ImportStateEnum.DRAFT.getCode().equals(tbInWarehouse.getState()) || ImportStateEnum.NOT_GO.getCode().equals(tbInWarehouse.getState())) {
            Map<String, Object> verify = verify(inWarehouse);
            if (verify.get("success").equals(false)) {
                return R.error(verify.get("msg") + "");
            }
            analyze(inWarehouse);
            inWarehouse.setState(ImportStateEnum.APPROVAL_PENDING.getCode());
            int i = inWarehouseMapper.updateByPrimaryKey(inWarehouse);
            return i > 0 ? R.ok() : R.error();
        } else {
            return R.error("该入仓通知单无法编辑");
        }
    }

    /**
     * 录入明细提交
     *
     * @param inWarehouse 入仓单明细信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult inputDetail(InWarehouseDetailDto inWarehouse, CurrentUser currentUser) {
        TbInWarehouse tbInWarehouse = inWarehouseMapper.selectByPrimaryKey(inWarehouse.getId());
        if (tbInWarehouse == null) {
            return ResponseResult.error("入仓通知单信息不存在");
        }
        if (ImportStateEnum.RUNNING.getCode().equals(tbInWarehouse.getState())) {
            Map<String, Object> map = verifyDetail(inWarehouse, tbInWarehouse);
            if (map.get("success").equals(false)) {
                return ResponseResult.error(map.get("msg") + "");
            }
            analyze2(inWarehouse, tbInWarehouse);
//            inWarehouse.setState(ImportStateEnum.RUNNING.getCode());
//            inWarehouseMapper.changState(inWarehouse.getId(), inWarehouse.getState(), currentUser);
            inWarehouse.getDeletes().addAll(inWarehouse.getDetailed().stream().filter(e -> e.getId() != null).map(ListDto::getId).collect(toList()));
//            if (inWarehouse.getDeletes().size() > 0) {
                inWarehouseDetailedMapper.batchDelete(inWarehouse, currentUser);
                inWarehouseDetailedCheckMapper.batchDelete(inWarehouse);
//            }
            if (inWarehouse.getDetailed().size() > 0 ) {
                inWarehouseDetailedMapper.batchInsert(inWarehouse, currentUser);
            }
            return ResponseResult.success();
        } else {
            return ResponseResult.error("该条数据无法实现录入明细提交");
        }
    }

    /**
     * 审批
     *
     * @param approveDto 审批入参
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult approve(ApproveDto approveDto, CurrentUser currentUser, List<String> roleIds) {
        TbInWarehouse tbInWarehouse = inWarehouseMapper.selectByPrimaryKey(approveDto.getId());
        if (tbInWarehouse == null) {
            return ResponseResult.error("入仓单信息不存在");
        }
        if (ImportStateEnum.APPROVAL_PENDING.getCode().equals(tbInWarehouse.getState())) {
            String code;
            if (approveDto.isPass()) {
                if (roleIds.contains(RoleEnum.COMPANY_LEADER.getCode())) {
                    code = ImportStateEnum.RUNNING.getCode();
                } else {
                    code = ImportStateEnum.APPROVAL_PENDING.getCode();
                }
            } else {
                code = ImportStateEnum.NOT_GO.getCode();
            }
            inWarehouseMapper.changState(approveDto.getId(), code, currentUser);
//            inWarehouseDetailedCheckMapper.insert(tbInWarehouse, approveDto, currentUser);
            List<Long> ids = inWarehouseMapper.getNextId(currentUser.getOrganizeId(), currentUser.getLq(), ImportStateEnum.APPROVAL_PENDING.getCode());
            return ResponseResult.success(ids.size() == 0 ? "" : ids.get(0));
        } else {
            return ResponseResult.error("该条数据没有审批操作");
        }
    }

    /**
     * 审核
     *
     * @param auditDto 审核入参
     * @param currentUser
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult audit(AuditDto auditDto, CurrentUser currentUser, List<String> roleIds) {
        TbInWarehouse tbInWarehouse = inWarehouseMapper.selectByPrimaryKey(auditDto.getId());
        if (tbInWarehouse == null) {
            return ResponseResult.error("入仓单信息不存在");
        }
        if (ImportStateEnum.RUNNING.getCode().equals(tbInWarehouse.getState())) {
            Integer num = inWarehouseDetailedMapper.check(auditDto.getId(), auditDto.getIds());
            if (num != auditDto.getIds().size()) {
                return ResponseResult.error("数据有误");
            }
//            if (auditDto.isPass()) {
//                inWarehouseDetailedMapper.correct(auditDto.getIds(), currentUser);
//                inWarehouseDetailedCheckMapper.insertTrue(InOrOutEnum.IN.getCode(), auditDto, currentUser);
////                Double b = inWarehouseDetailedMapper.count(auditDto.getIds());
//                grainActualInventoryMapper.batchInsert(tbInWarehouse, inWarehouseDetailedMapper.getListByIds(auditDto.getIds()));
//                // 验证是否完成
//                TbInWarehouse inWarehouse = inWarehouseMapper.selectByPrimaryKey(auditDto.getId());
//                List<InWarehouseDetailVo> list = inWarehouseDetailedMapper.get(auditDto.getId());
//                BigDecimal bigDecimal = new BigDecimal(0);
//                for (InWarehouseDetailVo detailVo : list) {
//                    if (AuditStateEnum.COMPLETE.getCode().equals(detailVo.getIsAudit())) {
//                        bigDecimal = bigDecimal.add(new BigDecimal(detailVo.getQuantity()));
//                    }
//                }
//                if (inWarehouse.getQuantity() == bigDecimal.doubleValue()) {
//                    inWarehouseMapper.changState(auditDto.getId(), ImportStateEnum.COMPLETED.getCode(), currentUser);
//                }
//            } else {
//                // 明细表数据状态修改
//                inWarehouseDetailedMapper.wrong(auditDto.getId(), auditDto.getIds(), currentUser);
//                inWarehouseDetailedMapper.correct(auditDto.getIds(), currentUser);
//                inWarehouseDetailedCheckMapper.insertTrue2(InOrOutEnum.IN.getCode(), auditDto.getIds(), currentUser);
//                inWarehouseDetailedCheckMapper.insertFalse(InOrOutEnum.IN.getCode(), auditDto, auditDto.getIds(), currentUser);
//
//            }
//            List<Long> ids = inWarehouseMapper.getNextId2(currentUser.getOrganizeId(), currentUser.getLq(), AuditStateEnum.WAIT.getCode());
//            return ResponseResult.success(ids.size() == 0 ? "" : ids.get(0));
            return ResponseResult.error("修改中");
        } else {
            return ResponseResult.error("该条数据没有审核操作");
        }
    }

    /**
     * 入仓单录入明细的添加按钮
     *
     * @param id 入仓通知单id
     * @return
     */
    @Override
    public List<ListVo> getInsertButton(Long id) {
        List<ListVo> insertButton = inWarehouseMapper.getInsertButton(id);
        for (ListVo listVo : insertButton) {
            if (listVo.getCapacity().equals(listVo.getPreviousStock())) {
                listVo.setType("1");
            } else {
                listVo.setType("0");
            }
        }
        return insertButton;
    }

    /**
     * 完善数据错误时的明细信息
     *
     * @param inWarehouse 入仓单信息
     */
    private void analyze2(InWarehouseDetailDto inWarehouse, TbInWarehouse tbInWarehouse) {
        for (ListDto dto : inWarehouse.getDetailed()) {
            dto.setGrainDepotName(tbInWarehouse.getGrainDepotName());
            dto.setStorehouseName(tbInWarehouse.getStorehouseName());
            dto.setHeapName(pileMapper.selectByPrimaryKey(dto.getHeapId()).getPileName());
            if (dto.getChildHeapId() != null) {
                dto.setChildHeapCode(childPileMapper.selectByPrimaryKey(dto.getChildHeapId()).getPileCode());
            }
        }
    }

    /**
     * 验证入仓单信息以及明细表信息
     *
     * @param inWarehouse 前端传的入仓单明细信息
     * @param tbInWarehouse 数据库内的入仓单信息
     * @return 结果
     */
    public Map<String, Object> verifyDetail(InWarehouseDetailDto inWarehouse, TbInWarehouse tbInWarehouse) {
//        if (ImportStateEnum.RUNNING.getCode().equals(tbInWarehouse.getState()) && inWarehouse.getDeletes().size() > 0) {
//            return BaseMap.getFailureMap("数据有误");
//        }
        List<Long> ids = inWarehouse.getDetailed().stream().filter(e -> e.getId() != null).map(ListDto::getId).collect(toList());
        ids.addAll(inWarehouse.getDeletes());
        Integer num2 = inWarehouseDetailedMapper.check2(inWarehouse.getId(), ids);
        if (num2 != ids.size()) {
            return BaseMap.getFailureMap("数据错误");
        }
        List<ListDto> detailed = inWarehouse.getDetailed();
        Set<String> heapIds = new HashSet<>();
        BigDecimal bigDecimal = new BigDecimal(0);
        for (ListDto dto : detailed) {
            if (!tbInWarehouse.getGrainOrganizeId().equals(dto.getGrainDepotId()) || !tbInWarehouse.getStorehouseId().equals(dto.getStorehouseId()) || dto.getQuantity() <= 0) {
                return BaseMap.getFailureMap("数据错误");
            }
            heapIds.add(dto.getHeapId() + "," + (dto.getChildHeapId() == null ? 0 : dto.getChildHeapId()));
            bigDecimal = bigDecimal.add(new BigDecimal(dto.getQuantity()));
        }
        List<InWarehouseDetailVo> list = inWarehouseDetailedMapper.get(inWarehouse.getId());
        for (InWarehouseDetailVo detailVo : list) {
            bigDecimal = bigDecimal.add(new BigDecimal(detailVo.getQuantity()));
        }
        if (tbInWarehouse.getQuantity() < bigDecimal.doubleValue()) {
            return BaseMap.getFailureMap("入仓数量总和超过入仓通知单设置的数量");
        }
        Integer num = pileMapper.check(heapIds, tbInWarehouse.getStorehouseId());
        if (!num.equals(heapIds.size())) {
            return BaseMap.getFailureMap("堆位数据错误");
        }
        return BaseMap.getSuccessMap();
    }

    /**
     * 验证入仓单数据是否正确
     *
     * @param inWarehouse 入仓单信息
     * @return 结果
     */
    public Map<String, Object> verify(TbInWarehouse inWarehouse) {
        if (StringUtils.isBlank(inWarehouse.getWarehousingType()) || inWarehouse.getBatchId() == null || inWarehouse.getVarietyId() == null
                || StringUtils.isBlank(inWarehouse.getGrade()) || inWarehouse.getGrainDepotId() == null || inWarehouse.getStorehouseId() == null
                || inWarehouse.getQuantity() == null || inWarehouse.getPrice() == null || StringUtils.isBlank(inWarehouse.getPacking())
                || StringUtils.isBlank(inWarehouse.getParticularYear()) || StringUtils.isBlank(inWarehouse.getInWarehouseCode())
                || StringUtils.isBlank(inWarehouse.getProducingArea())) {
            return BaseMap.getFailureMap("数据不完整");
        }
        if (inWarehouse.getPrice() <= 0) {
            return BaseMap.getFailureMap("数据错误");
        }
        if ("1".equals(inWarehouse.getProducingArea())) {
            if (StringUtils.isBlank(inWarehouse.getProducingProvince())) {
                return BaseMap.getFailureMap("数据不完整");
            }
        }
        if ("2".equals(inWarehouse.getProducingArea())) {
            if (StringUtils.isBlank(inWarehouse.getCountry())) {
                return BaseMap.getFailureMap("数据不完整");
            }
        }
        if ("1".equals(inWarehouse.getPacking())) {
            if (StringUtils.isBlank(inWarehouse.getPackingMaterial()) || inWarehouse.getPackingNumber() == null) {
                return BaseMap.getFailureMap("数据不完整");
            }
        }
        // 验证批文编号,粮库id,仓房id,粮油品种id是否正确
        if ("1".equals(inWarehouse.getWarehousingType())) {
            // 验证招标入库时存储合同数据的正确性
            Integer num = inWarehouseMapper.check(inWarehouse);
            if (num == 0) {
                return BaseMap.getFailureMap("数据错误");
            }
        } else if ("2".equals(inWarehouse.getWarehousingType())) {
            // 验证轮换入库时数据正确性
            return BaseMap.getFailureMap("暂时只有招标入库");
        } else if ("3".equals(inWarehouse.getWarehousingType())) {
            // 验证移库入库时数据正确性
            return BaseMap.getFailureMap("暂时只有招标入库");
        } else {
            return BaseMap.getFailureMap("数据错误");
        }
        return BaseMap.getSuccessMap();
    }
}
