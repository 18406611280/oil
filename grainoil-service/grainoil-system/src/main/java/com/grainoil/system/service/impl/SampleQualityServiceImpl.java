package com.grainoil.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.page.PageView;
import com.grainoil.common.enums.QualityApplyStatusEnum;
import com.grainoil.common.enums.QualityTypeEnum;
import com.grainoil.common.utils.DateUtils;
import com.grainoil.system.domain.quality.TbQualityApply;
import com.grainoil.system.domain.quality.TbQualityApplyDetailed;
import com.grainoil.system.domain.quality.dto.DailySampleQualityAddDto;
import com.grainoil.system.domain.quality.dto.SampleApplyDto;
import com.grainoil.system.domain.quality.dto.SampleDto;
import com.grainoil.system.domain.quality.dto.SamplePageDto;
import com.grainoil.system.domain.vo.quality.FoodCheckItemVo;
import com.grainoil.system.domain.vo.quality.SampleQualityApplyPageVo;
import com.grainoil.system.domain.vo.quality.SampleQualityDetailVo;
import com.grainoil.system.domain.vo.quality.SampleQualityPageVo;
import com.grainoil.system.mapper.quality.TbQualityApplyDetailedMapper;
import com.grainoil.system.mapper.quality.TbQualityApplyMapper;
import com.grainoil.system.mapper.quality.TbQualityCheckResultMapper;
import com.grainoil.system.service.SampleApplicationService;
import com.grainoil.system.service.SampleQualityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/21 16:36
 */
@Service
public class SampleQualityServiceImpl implements SampleQualityService {

    @Autowired
    private TbQualityApplyMapper qualityApplyMapper;

    @Autowired
    private TbQualityApplyDetailedMapper qualityApplyDetailedMapper;

    @Autowired
    private SampleApplicationService sampleApplicationService;

    @Autowired
    private TbQualityCheckResultMapper qualityCheckResultMapper;

    @Override
    public PageView<SampleQualityPageVo> page(SamplePageDto samplePageDto, QualityTypeEnum qualityTypeEnum) {
        PageHelper.startPage(samplePageDto.getCurrent(), samplePageDto.getPageSize());
        List<SampleQualityPageVo> pageVoList = qualityApplyMapper.selectQualityPage(samplePageDto,qualityTypeEnum.code);
        for (SampleQualityPageVo pageVo : pageVoList) {
            Date minDate = pageVo.getWarehouseStartDate();
            Date maxDate = pageVo.getWarehouseEndDate();
            pageVo.setWarehouseDate(DateUtils.parseDateToStr(minDate)+"~"+DateUtils.parseDateToStr(maxDate));
        }
        PageInfo<SampleQualityApplyPageVo> pageInfo = new PageInfo(pageVoList);
        return new PageView(pageInfo);
    }

    @Override
    @Transactional
    public void addDailyQuality(DailySampleQualityAddDto addDto, CurrentUser currentUser) {
        SampleApplyDto sampleApplyDto = new SampleApplyDto();
        sampleApplyDto.setGrainDepotId(addDto.getGrainDepotId());
        //样品详情
        SampleDto sampleDto = new SampleDto();
        sampleDto.setInventoryId(addDto.getInventoryId());
        sampleDto.setSampleName("日常抽检");
        //保存质检申请
        TbQualityApply qualityApply = sampleApplicationService.saveQualityApply(sampleApplyDto, currentUser, QualityTypeEnum.DAY, QualityApplyStatusEnum.COMPLETED.code);
        //保存质检详情
        TbQualityApplyDetailed tbQualityApplyDetailed = sampleApplicationService.saveQualityApplyDetail(qualityApply, sampleDto);
        List<FoodCheckItemVo> foodCheckItemVos = addDto.getFoodCheckItemVos();
        //保存质检结果
        sampleApplicationService.saveCheckResult(tbQualityApplyDetailed.getId(),foodCheckItemVos);

    }

    @Override
    public SampleQualityDetailVo detail(Long sampleId) {
        TbQualityApplyDetailed tbQualityApplyDetailed = qualityApplyDetailedMapper.selectByPrimaryKey(sampleId);
        SampleQualityDetailVo detailVo = new SampleQualityDetailVo();
        BeanUtils.copyProperties(tbQualityApplyDetailed,detailVo);
        Date minDate = tbQualityApplyDetailed.getWarehouseStartDate();
        Date maxDate = tbQualityApplyDetailed.getWarehouseEndDate();
        detailVo.setWarehouseDate(DateUtils.parseDateToStr(minDate)+"~"+DateUtils.parseDateToStr(maxDate));
        List<FoodCheckItemVo> foodCheckItemVos = qualityCheckResultMapper.selectCheckResult(sampleId);
        detailVo.setFoodCheckItemVos(foodCheckItemVos);
        return detailVo;
    }

    @Override
    public void addDeliveryQuality(DailySampleQualityAddDto addDto, CurrentUser currentUser) {
        SampleApplyDto sampleApplyDto = new SampleApplyDto();
        sampleApplyDto.setGrainDepotId(addDto.getGrainDepotId());
        //样品详情
        SampleDto sampleDto = new SampleDto();
        sampleDto.setInventoryId(addDto.getInventoryId());
        sampleDto.setSampleName("出库抽检");
        //保存质检申请
        TbQualityApply qualityApply = sampleApplicationService.saveQualityApply(sampleApplyDto, currentUser, QualityTypeEnum.OUT, QualityApplyStatusEnum.COMPLETED.code);
        //保存质检详情
        TbQualityApplyDetailed tbQualityApplyDetailed = sampleApplicationService.saveQualityApplyDetail(qualityApply, sampleDto);
        List<FoodCheckItemVo> foodCheckItemVos = addDto.getFoodCheckItemVos();
        //保存质检结果
        sampleApplicationService.saveCheckResult(tbQualityApplyDetailed.getId(),foodCheckItemVos);
    }
}
