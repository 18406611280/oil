package com.grainoil.activiti.mapper;

import java.util.List;

import com.grainoil.activiti.vo.HiProcInsVo;

public interface HistoryMapper
{
    List<HiProcInsVo> getHiProcInsListDone(HiProcInsVo hiProcInsVo);
}