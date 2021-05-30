package com.grainoil.activiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grainoil.activiti.mapper.HistoryMapper;
import com.grainoil.activiti.service.IHistoryInfoService;
import com.grainoil.activiti.vo.HiProcInsVo;

/**
 * 
 *
 * @Auther: Ace Lee
 * @Date: 2019/3/7 16:55
 */
@Service
public class HistoryInfoServiceImpl implements IHistoryInfoService
{
    @Autowired
    private HistoryMapper historyMapper;

    /* (non-Javadoc)
     * @see com.grainoil.activiti.service.IHistoryInfoService#getHiProcInsListDone(com.grainoil.activiti.vo.HiProcInsVo)
     */
    @Override
    public List<HiProcInsVo> getHiProcInsListDone(HiProcInsVo hiProcInsVo)
    {
        return historyMapper.getHiProcInsListDone(hiProcInsVo);
    }
}
