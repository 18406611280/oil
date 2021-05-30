package com.grainoil.system.service.impl;

import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.mapper.TbOrganizeLqMapper;
import com.grainoil.system.service.ITbOrganizeLqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TbOrganizeLqServiceImpl implements ITbOrganizeLqService {

    @Autowired
    TbOrganizeLqMapper organizeLqMapper;

    /**
     * 根据组织id获取粮权信息
     *
     * @param organizeId 组织id
     * @return 粮权信息
     */
    @Override
    public List<Map<String, Object>> getLq(Long organizeId) {
        return organizeLqMapper.getLq(organizeId);
    }

    /**
     * 获取承储企业下拉框
     *
     * @param organizeId
     * @return
     */
    @Override
    public List<LeafNode> getCompanyList(Long organizeId) {
        return organizeLqMapper.getCompanyList(organizeId);
    }
}
