package com.grainoil.system.service;

import com.grainoil.system.domain.vo.common.LeafNode;

import java.util.List;
import java.util.Map;

public interface ITbOrganizeLqService {

    /**
     * 根据组织id获取粮权信息
     *
     * @param organizeId 组织id
     * @return 粮权信息
     */
    List<Map<String,Object>> getLq(Long organizeId);

    /**
     * 获取承储企业下拉框
     *
     * @param organizeId
     * @return
     */
    List<LeafNode> getCompanyList(Long organizeId);
}
