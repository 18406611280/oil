package com.grainoil.activiti.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.grainoil.activiti.consts.ActivitiConstant;
import com.grainoil.activiti.domain.BizNode;
import com.grainoil.activiti.mapper.BizNodeMapper;
import com.grainoil.activiti.service.IBizNodeService;
import com.grainoil.activiti.vo.ProcessNodeVo;
import com.grainoil.system.domain.SysDept;
import com.grainoil.system.domain.SysUser;
import com.grainoil.system.feign.RemoteDeptService;
import com.grainoil.system.feign.RemoteUserService;

import cn.hutool.core.util.StrUtil;

/**
 * 节点Service业务层处理
 * 
 * @author grainoil
 * @date 2020-01-07
 */
@Service
public class BizNodeServiceImpl implements IBizNodeService
{
    @Autowired
    private BizNodeMapper     bizNodeMapper;

    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private RemoteDeptService remoteDeptService;

    /**
     * 查询节点
     * 
     * @param id 节点ID
     * @return 节点
     */
    @Override
    public BizNode selectBizNodeById(Long id)
    {
        return bizNodeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询节点列表
     * 
     * @param bizNode 节点
     * @return 节点
     */
    @Override
    public List<BizNode> selectBizNodeList(BizNode bizNode)
    {
        return bizNodeMapper.select(bizNode);
    }

    /**
     * 新增节点
     * 
     * @param bizNode 节点
     * @return 结果
     */
    @Override
    public int insertBizNode(BizNode bizNode)
    {
        return bizNodeMapper.insertSelective(bizNode);
    }

    /* (non-Javadoc)
     * @see com.grainoil.activiti.service.IBizNodeService#setAuditors(java.lang.String)
     */
    @Override
    public ProcessNodeVo setAuditors(ProcessNodeVo node)
    {
        List<BizNode> bizNodes = selectBizNodeList(new BizNode().setNodeId(node.getNodeId()));
        List<Long> roleIds = Lists.newArrayList();
        List<Long> userIds = Lists.newArrayList();
        List<Long> deptIds = Lists.newArrayList();
        for (BizNode bizNode : bizNodes)
        {
            // 设置关联角色
            if (bizNode.getType().equals(ActivitiConstant.NODE_ROLE))
            {
                roleIds.add(bizNode.getAuditor());
            }
            // 设置关联部门
            else if (bizNode.getType().equals(ActivitiConstant.NODE_DEPARTMENT))
            {
                deptIds.add(bizNode.getAuditor());
            }
            // 设置关联用户
            else if (bizNode.getType().equals(ActivitiConstant.NODE_USER))
            {
                userIds.add(bizNode.getAuditor());
            }
            else if (bizNode.getType().equals(ActivitiConstant.NODE_DEP_HEADER))
            {
                // 是否设置操作人负责人
                node.setDeptHeader(true);
            }
        }
        // 设置关联角色
        node.setRoleIds(roleIds);
        // 设置关联部门
        node.setDeptIds(deptIds);
        // 设置关联用户
        node.setUserIds(userIds);
        return node;
    }

    /* (non-Javadoc)
     * @see com.grainoil.activiti.service.IBizNodeService#updateBizNode(com.grainoil.activiti.vo.ProcessNodeVo)
     */
    @Override
    public int updateBizNode(ProcessNodeVo node)
    {
        // 删除所有节点信息
        bizNodeMapper.delete(new BizNode().setNodeId(node.getNodeId()));
        List<BizNode> bizNodes = Lists.newArrayList();
        List<Long> roleIds = node.getRoleIds();
        if (null != roleIds && roleIds.size() > 0)
        {
            for (Long roleId : roleIds)
            {
                bizNodes.add(new BizNode().setNodeId(node.getNodeId()).setType(ActivitiConstant.NODE_ROLE)
                        .setAuditor(roleId));
            }
        }
        List<Long> deptIds = node.getDeptIds();
        if (null != deptIds && deptIds.size() > 0)
        {
            for (Long deptId : node.getDeptIds())
            {
                bizNodes.add(new BizNode().setNodeId(node.getNodeId()).setType(ActivitiConstant.NODE_DEPARTMENT)
                        .setAuditor(deptId));
            }
        }
        List<Long> userIds = node.getUserIds();
        if (null != userIds && userIds.size() > 0)
        {
            for (Long userId : userIds)
            {
                bizNodes.add(new BizNode().setNodeId(node.getNodeId()).setType(ActivitiConstant.NODE_USER)
                        .setAuditor(userId));
            }
        }
        if (null != node.getDeptHeader() && node.getDeptHeader())
        {
            bizNodes.add(new BizNode().setNodeId(node.getNodeId()).setType(ActivitiConstant.NODE_DEP_HEADER));
        }
        return bizNodes.isEmpty() ? 0 : bizNodeMapper.insertList(bizNodes);
    }

    /* (non-Javadoc)
     * @see com.grainoil.activiti.service.IBizNodeService#getAuditors(java.lang.String)
     */
    @Override
    public Set<String> getAuditors(String nodeId, long userId)
    {
        // TODO 优化查询次数可以将同类型审核人一次性查询得到
        List<BizNode> bizNodes = selectBizNodeList(new BizNode().setNodeId(nodeId));
        Set<Long> auditors = Sets.newHashSet();
        Set<Long> roleIds = Sets.newHashSet();
        Set<Long> deptIds = Sets.newHashSet();
        if (null != bizNodes && bizNodes.size() > 0)
        {
            for (BizNode node : bizNodes)
            {
                if (node.getType().equals(ActivitiConstant.NODE_USER))
                {
                    // 如果是用户类型直接塞到审核人结合
                    auditors.add(node.getAuditor());
                }
                else if (node.getType().equals(ActivitiConstant.NODE_ROLE))
                {
                    // 查询所有拥有有当前角色编号的用户
                    roleIds.add(node.getAuditor());
                }
                else if (node.getType().equals(ActivitiConstant.NODE_DEPARTMENT))
                {
                    deptIds.add(node.getAuditor());
                }
                else if (node.getType().equals(ActivitiConstant.NODE_DEP_HEADER))
                {
                    SysUser user = remoteUserService.selectSysUserByUserId(userId);
                    SysDept dept = remoteDeptService.selectSysDeptByDeptId(user.getDeptId());
                    // 查询所有用有当前用户部门的负责人
                    auditors.add(dept.getLeaderId());
                }
            }
        }
        if (roleIds.size() > 0)
        {
            auditors.addAll(remoteUserService.selectUserIdsHasRoles(StrUtil.join(",", roleIds.toArray())));
        }
        if (deptIds.size() > 0)
        {
            auditors.addAll(remoteUserService.selectUserIdsInDepts(StrUtil.join(",", deptIds.toArray())));
        }
        return auditors.stream().map(m -> m.toString()).collect(Collectors.toSet());
    }
}
