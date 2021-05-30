package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TbUserMapper {
    /**
     * 根据条件分页查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    List<TbUser> selectUserList(TbUser sysUser);

    /**
     * 根据条件分页查询未已配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<TbUser> selectAllocatedList(TbUser user);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<TbUser> selectUnallocatedList(TbUser user);

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
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(TbUser user);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(TbUser user);

    /**
     * 校验登录名称是否唯一
     *
     * @param tbUser 用户信息
     * @param b      修改/添加
     * @return 结果
     */
    int checkLoginNameUnique(@Param("tbUser") TbUser tbUser, @Param("b") boolean b);

    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    TbUser checkPhoneUnique(String phonenumber);

    /**
     * 查询组织下角色是粮库负责人的用户列表
     *
     * @param organizeId 组织id
     * @return 用户列表
     */
    List<Map<String, Object>> findGrainDepot(Long organizeId);

    /**
     * 查询组织下角色是仓库保管员的用户列表
     *
     * @param organizeId 组织id
     * @return 用户列表
     */
    List<Map<String, Object>> findStorehouse(Long organizeId);

    /**
     * 根据组织和角色查询用户id集合
     *
     * @param organizeId
     * @param roleId
     * @return
     */
    List<Long> getUserIds(@Param("organizeId") Long organizeId, @Param("roleId") Long roleId);

    /**
     * 检验负责人的信息
     *
     * @param organizeId
     * @param roleId
     * @param personId
     * @return
     */
    Integer checkUserIds(@Param("organizeId") Long organizeId, @Param("roleId") Long roleId, @Param("personId") List<Long> personId);
}