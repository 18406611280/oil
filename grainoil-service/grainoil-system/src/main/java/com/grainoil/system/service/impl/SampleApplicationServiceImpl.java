package com.grainoil.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.OrganizeTypeEnum;
import com.grainoil.common.enums.QualityApplyStatusEnum;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.common.utils.DateUtils;
import com.grainoil.common.utils.ListUtils;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.common.utils.bean.BeanUtils;
import com.grainoil.system.domain.TbGrainActualInventory;
import com.grainoil.system.domain.TbGrainDepot;
import com.grainoil.system.domain.TbOrganize;
import com.grainoil.system.domain.quality.TbQualityApply;
import com.grainoil.system.domain.quality.TbQualityApplyDetailed;
import com.grainoil.system.domain.quality.TbQualityCheckResult;
import com.grainoil.system.domain.quality.dto.SampleApplyDto;
import com.grainoil.system.domain.quality.dto.SampleApplyEditDto;
import com.grainoil.system.domain.quality.dto.SampleApplyPageDto;
import com.grainoil.system.domain.quality.dto.SampleDto;
import com.grainoil.system.domain.vo.GrainDepVo;
import com.grainoil.system.domain.vo.quality.*;
import com.grainoil.system.mapper.TbGrainActualInventoryMapper;
import com.grainoil.system.mapper.TbGrainDepotMapper;
import com.grainoil.system.mapper.TbOrganizeMapper;
import com.grainoil.system.mapper.quality.TbQualityApplyDetailedMapper;
import com.grainoil.system.mapper.quality.TbQualityApplyMapper;
import com.grainoil.system.mapper.quality.TbQualityCheckResultMapper;
import com.grainoil.system.service.SampleApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: chenminghong
 * @Date: 2021/5/14 11:27
 */
@Service
public class SampleApplicationServiceImpl implements SampleApplicationService {

    @Autowired
    private TbOrganizeMapper organizeMapper;

    @Autowired
    private TbGrainActualInventoryMapper grainActualInventoryMapper;

    @Autowired
    private TbGrainDepotMapper grainDepotMapper;

    @Autowired
    private TbQualityApplyMapper qualityApplyMapper;

    @Autowired
    private TbQualityApplyDetailedMapper qualityApplyDetailedMapper;

    @Autowired
    private TbQualityCheckResultMapper qualityCheckResultMapper;


    @Override
    public SampleInformationVo getSampleInformation(CurrentUser currentUser) {
        SampleInformationVo sampleInformationVo = new SampleInformationVo();
        Long organizeId = currentUser.getOrganizeId();
        Long lq = currentUser.getLq();
        TbOrganize tbOrganize = organizeMapper.selectByPrimaryKey(organizeId);
        List<TbOrganize> organizeByType = organizeMapper.getOrganizeByType(OrganizeTypeEnum.QUALITY.code);
        if(CollectionUtil.isNotEmpty(organizeByType)){
            TbOrganize organize = organizeByType.get(0);
            sampleInformationVo.setQualityCompanyId(organize.getOrganizeId());
            sampleInformationVo.setQualityCompanyName(organize.getOrganizeName());
        }
        sampleInformationVo.setCompanyId(tbOrganize.getOrganizeId());
        sampleInformationVo.setCompanyName(tbOrganize.getOrganizeName());
        List<GrainDepVo> grainDepVos = grainActualInventoryMapper.selectGrainDepot(organizeId,lq);
        sampleInformationVo.setGrainVoList(grainDepVos);
        return sampleInformationVo;
    }

    @Override
    @Transactional
    public TbQualityApplyDetailed saveQualityApplyDetail(TbQualityApply apply, SampleDto sampleDto) {
        TbQualityApplyDetailed tbQualityApplyDetailed = new TbQualityApplyDetailed();
        long inventoryId = sampleDto.getInventoryId();
        TbGrainActualInventory tbGrainActualInventory = grainActualInventoryMapper.selectByPrimaryKey(inventoryId);
        BeanUtils.copyProperties(tbGrainActualInventory,tbQualityApplyDetailed);
        tbQualityApplyDetailed.setSamplingCode(apply.getApplyCode());
        tbQualityApplyDetailed.setApplyId(apply.getId());
        tbQualityApplyDetailed.setSampleCode(UUID.randomUUID().toString());
        tbQualityApplyDetailed.setSampleName(sampleDto.getSampleName());
        tbQualityApplyDetailed.setCheckResult(sampleDto.getCheckResult());
        String childHeapCode = tbGrainActualInventory.getChildHeapCode();
        if(StringUtils.isNotBlank(childHeapCode)){
            tbQualityApplyDetailed.setHeapName(childHeapCode);
            tbQualityApplyDetailed.setHeapId(tbGrainActualInventory.getChildHeapId());
        }
        tbQualityApplyDetailed.setSamplingTime(new Date());
        qualityApplyDetailedMapper.insert(tbQualityApplyDetailed);
        return tbQualityApplyDetailed;

    }

    @Override
    public PageView<SampleQualityApplyPageVo> page(SampleApplyPageDto sampleApplyPageDto) {
        PageHelper.startPage(sampleApplyPageDto.getCurrent(), sampleApplyPageDto.getPageSize());
        List<SampleQualityApplyPageVo> pageVoList = qualityApplyMapper.selectPage(sampleApplyPageDto);
        for (SampleQualityApplyPageVo pageVo : pageVoList) {
            Long applyId = pageVo.getId();
            List<TbQualityApplyDetailed> detailedList = qualityApplyDetailedMapper.selectByApplyId(applyId);
            pageVo.setSampleNumber(detailedList.size());
            if(CollectionUtil.isNotEmpty(detailedList)){
                pageVo.setQuantity(detailedList.stream().filter(d -> d.getQuantity()!=null).mapToDouble(TbQualityApplyDetailed::getQuantity).sum());
                //获取最小入库开始日期
                Date minDate = detailedList.stream().filter(d -> d.getWarehouseStartDate() != null).map(TbQualityApplyDetailed::getWarehouseStartDate).distinct().min(DateUtils::compareDate).get();
                Date maxDate = detailedList.stream().filter(d -> d.getWarehouseEndDate() != null).map(TbQualityApplyDetailed::getWarehouseEndDate).distinct().max(DateUtils::compareDate).get();
                pageVo.setWarehouseDate(DateUtils.parseDateToStr(minDate)+"~"+DateUtils.parseDateToStr(maxDate));
                String batchCode = detailedList.stream().map(TbQualityApplyDetailed::getBatchCode).collect(Collectors.joining(","));
                pageVo.setBatchCode(batchCode);
            }
            Long qualityOrg = pageVo.getQualityOrg();
            TbOrganize tbOrganize = organizeMapper.selectByPrimaryKey(qualityOrg);
            pageVo.setQualityOrgName(tbOrganize.getOrganizeName());
            String state = pageVo.getState();
            QualityApplyStatusEnum statusEnum = QualityApplyStatusEnum.getByCode(state);
            pageVo.setState(statusEnum ==null ? "" : statusEnum.value);
        }
        PageInfo<SampleQualityApplyPageVo> pageInfo = new PageInfo(pageVoList);
        return new PageView(pageInfo);
    }

    @Override
    public QualityApplyDetailVo getApplyDetail(Long applyId) {
        QualityApplyDetailVo qualityApplyDetailVo = new QualityApplyDetailVo();
        TbQualityApply qualityApply = qualityApplyMapper.selectByPrimaryKey(applyId);
        if(qualityApply == null) return null;
        BeanUtils.copyProperties(qualityApply,qualityApplyDetailVo);
        qualityApplyDetailVo.setCompanyName(qualityApply.getOrganizeName());
        Long qualityOrg = qualityApply.getQualityOrg();
        TbOrganize tbOrganize = organizeMapper.selectByPrimaryKey(qualityOrg);
        qualityApplyDetailVo.setQualityCompanyName(tbOrganize == null ? "" : tbOrganize.getOrganizeName());
        List<TbQualityApplyDetailed> tbQualityApplyDetaileds = qualityApplyDetailedMapper.selectByApplyId(applyId);
        List<SampleVo> sampleVos = new ArrayList<>();
        for (TbQualityApplyDetailed tbQualityApplyDetailed : tbQualityApplyDetaileds) {
            SampleVo sampleVo = new SampleVo();
            BeanUtils.copyProperties(tbQualityApplyDetailed,sampleVo);
            Date warehouseStartDate = tbQualityApplyDetailed.getWarehouseStartDate();
            Date warehouseEndDate = tbQualityApplyDetailed.getWarehouseEndDate();
            String startDate = DateUtils.parseDateToStr("yyyy-MM-dd",warehouseStartDate);
            String endDate = DateUtils.parseDateToStr("yyyy-MM-dd",warehouseEndDate);
            sampleVo.setWarehouseDate(startDate+"~"+endDate);
            sampleVos.add(sampleVo);
        }
        qualityApplyDetailVo.setSampleVoList(sampleVos);
        return qualityApplyDetailVo;
    }

    @Override
    @Transactional
    public void editApply(SampleApplyEditDto applyEditDto) {
        Long id = applyEditDto.getId();
        TbQualityApply qualityApply = qualityApplyMapper.selectByPrimaryKey(id);
        qualityApply.setRemark(qualityApply.getRemark());
        qualityApplyMapper.updateByPrimaryKeySelective(qualityApply);
        List<SampleDto> sampleDtoList = applyEditDto.getSampleDtoList();
        List<Long> newIds = sampleDtoList.stream().map(SampleDto::getId).collect(Collectors.toList());
        List<TbQualityApplyDetailed> sourceDetaileds = qualityApplyDetailedMapper.selectByApplyId(id);
        List<Long> sourceIds = sourceDetaileds.stream().map(TbQualityApplyDetailed::getId).collect(Collectors.toList());
        //查询要删除的记录
        List<Long> deleteIds = ListUtils.getRightCompare(newIds, sourceIds);
        for (Long deleteId : deleteIds) {
            qualityApplyDetailedMapper.deleteByPrimaryKey(deleteId);
        }
        for (SampleDto sampleDto : sampleDtoList) {
            Long samId = sampleDto.getId();
            //新增
            if(samId == null){
                TbQualityApplyDetailed tbQualityApplyDetailed = new TbQualityApplyDetailed();
                long inventoryId = sampleDto.getInventoryId();
                TbGrainActualInventory tbGrainActualInventory = grainActualInventoryMapper.selectByPrimaryKey(inventoryId);
                BeanUtils.copyProperties(tbGrainActualInventory,tbQualityApplyDetailed);
                tbQualityApplyDetailed.setSamplingCode(qualityApply.getApplyCode());
                tbQualityApplyDetailed.setApplyId(qualityApply.getId());
                tbQualityApplyDetailed.setSampleCode(UUID.randomUUID().toString());
                tbQualityApplyDetailed.setSampleName(sampleDto.getSampleName());
                String childHeapCode = tbGrainActualInventory.getChildHeapCode();
                if(StringUtils.isNotBlank(childHeapCode)){
                    tbQualityApplyDetailed.setHeapName(childHeapCode);
                    tbQualityApplyDetailed.setHeapId(tbGrainActualInventory.getChildHeapId());
                }
                tbQualityApplyDetailed.setSamplingTime(new Date());
                qualityApplyDetailedMapper.insert(tbQualityApplyDetailed);
            }else{//修改
                TbQualityApplyDetailed tbQualityApplyDetailed = qualityApplyDetailedMapper.selectByPrimaryKey(samId);
                tbQualityApplyDetailed.setSampleName(sampleDto.getSampleName());
                qualityApplyDetailedMapper.updateByPrimaryKeySelective(tbQualityApplyDetailed);
            }
        }


    }

    /**
     * 保存质检申请表（通用）
     * @param sampleApplyDto
     * @param currentUser
     * @param typeEnum 申请类型
     * @param status 申请状态
     * @return
     */
    @Transactional
    @Override
    public TbQualityApply saveQualityApply(SampleApplyDto sampleApplyDto, CurrentUser currentUser, QualityTypeEnum typeEnum, String status) {
        TbQualityApply qualityApply = new TbQualityApply();
        SampleInformationVo sampleInformation = getSampleInformation(currentUser);
        TbOrganize tbOrganize = organizeMapper.selectByPrimaryKey(currentUser.getLq());
        qualityApply.setGrainOwnerId(currentUser.getLq());
        qualityApply.setGrainOwnerName(tbOrganize.getOrganizeName());
        qualityApply.setApplyType(typeEnum.code);
        qualityApply.setApplyCode(UUID.fastUUID().toString());
        qualityApply.setQualityOrg(currentUser.getLq());
        qualityApply.setOrganizeId(sampleInformation.getCompanyId());
        qualityApply.setOrganizeName(sampleInformation.getCompanyName());
        qualityApply.setApplyDate(new Date());
        qualityApply.setSamplers(currentUser.getCurrentName());
        Long grainDepotId = sampleApplyDto.getGrainDepotId();
        qualityApply.setGrainDepotId(grainDepotId);
        if(grainDepotId!=null){
            TbGrainDepot tbGrainDepot = grainDepotMapper.selectByPrimaryKey(grainDepotId);
            qualityApply.setGrainDepotName(tbGrainDepot.getGrainDepotName());
            qualityApply.setGrainDepotPosition(tbGrainDepot.getGrainDepotPosition());
        }
        qualityApply.setRemark(sampleApplyDto.getRemark());
        qualityApply.setState(status);
        qualityApply.setCreateBy(currentUser.getCurrentName());
        qualityApply.setCreateId(currentUser.getCurrentId());
        qualityApply.setCreateTime(new Date());
        qualityApplyMapper.insert(qualityApply);
        return qualityApply;

    }

    @Override
    @Transactional
    public void saveCheckResult(Long applyDetailId, List<FoodCheckItemVo> foodCheckItemVos) {
        for (FoodCheckItemVo foodCheckItemVo : foodCheckItemVos) {
            TbQualityCheckResult checkResult = new TbQualityCheckResult();
            checkResult.setQualityCheckId(foodCheckItemVo.getCheckItemId());
            checkResult.setQualityCheckResult(foodCheckItemVo.getCheckResult());
            checkResult.setQualityApplyDetailedId(applyDetailId);
            qualityCheckResultMapper.insert(checkResult);
        }

    }

    @Override
    @Transactional
    public void receive(Long applyId) {
        TbQualityApply qualityApply = qualityApplyMapper.selectByPrimaryKey(applyId);
        qualityApply.setState(QualityApplyStatusEnum.TO_BE_SAMPLE.code);
        qualityApplyMapper.updateByPrimaryKeySelective(qualityApply);
    }
}
