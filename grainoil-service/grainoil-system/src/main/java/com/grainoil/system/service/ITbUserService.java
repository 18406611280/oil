package com.grainoil.system.service;

import com.grainoil.common.core.domain.R;
import com.grainoil.system.domain.TbUser;

import java.util.List;

public interface ITbUserService {

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    List<TbUser> selectUserList(TbUser user);

    /**
     * 根据条件分页查询已分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
//    public List<TbUser> selectAllocatedList(TbUser user);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
//    public List<TbUser> selectUnallocatedList(TbUser user);

    /**
     * 通过登录名查询用户
     *
     * @param loginName 登录名
     * @return 用户对象信息
     */
    TbUser selectUserByLoginName(String loginName);

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    TbUser selectUserById(Long userId);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
//    public int deleteUserById(Long userId);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    R insertUser(TbUser user);

    /**
     * 保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    R updateUser(TbUser user);

    /**
     * 修改用户详细信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(TbUser user);

    /**
     * 修改用户密码信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(TbUser user);

    /**
     * 根据用户ID查询用户所属角色组
     *
     * @param userId 用户ID
     * @return 结果
     */
//    public String selectUserRoleGroup(Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
//    public String selectUserPostGroup(Long userId);

    /**
     * 用户状态修改
     *
     * @param user 用户信息
     * @return 结果
     */
    public int changeStatus(TbUser user);
}
