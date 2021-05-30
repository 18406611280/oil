package com.grainoil.system.service.impl;

import com.grainoil.common.constant.UserConstants;
import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.common.utils.security.Md5Utils;
import com.grainoil.system.domain.TbUser;
import com.grainoil.system.mapper.TbUserMapper;
import com.grainoil.system.service.ITbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class TbUserServiceImpl implements ITbUserService {

    private static final Logger log = LoggerFactory.getLogger(TbUserServiceImpl.class);

    private static final Pattern PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");

    @Autowired
    TbUserMapper userMapper;

//    @Autowired
//    private TbRoleMapper       roleMapper;

//    @Autowired
//    private SysUserRoleMapper   userRoleMapper;

    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
//    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TbUser> selectUserList(TbUser user) {
        return userMapper.selectUserList(user);
    }

    /**
     * 根据条件分页查询已分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
//    @DataScope(deptAlias = "d", userAlias = "u")
//    public List<TbUser> selectAllocatedList(TbUser user)
//    {
//        return userMapper.selectAllocatedList(user);
//    }

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
//    @DataScope(deptAlias = "d", userAlias = "u")
//    public List<TbUser> selectUnallocatedList(TbUser user)
//    {
//        return userMapper.selectUnallocatedList(user);
//    }

    /**
     * 通过登录名查询用户
     *
     * @param loginName 登录名
     * @return 用户对象信息
     */
    @Override
    public TbUser selectUserByLoginName(String loginName) {
        return userMapper.selectUserByLoginName(loginName);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public TbUser selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
//    @Override
//    public int deleteUserById(Long userId)
//    {
//        // 删除用户与角色关联
//        userRoleMapper.deleteUserRoleByUserId(userId);
//        // 删除用户与岗位表
//        userPostMapper.deleteUserPostByUserId(userId);
//        return userMapper.deleteUserById(userId);
//    }

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R insertUser(TbUser user) {
        verify(user, false);
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        return null;
    }

    /**
     * 修改保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R updateUser(TbUser user)
    {
        Long userId = user.getUserId();
//        return userMapper.updateUser(user);
        return null;
    }

    /**
     * 修改用户个人详细信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(TbUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户密码
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetUserPwd(TbUser user)
    {
        return updateUserInfo(user);
    }


    /**
     * 校验登录名称是否唯一
     *
     * @return
     */
    public String checkLoginNameUnique(TbUser tbUser, boolean b) {
        int count = userMapper.checkLoginNameUnique(tbUser, b);
        if (count > 0) {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验手机号是否唯一
     *
     * @param user 用户信息
     * @return
     */
    public String checkPhoneUnique(TbUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        TbUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    /**
     * 查询用户所属角色组
     *
     * @param userId 用户ID
     * @return 结果
     */
//    @Override
//    public String selectUserRoleGroup(Long userId)
//    {
//        List<SysRole> list = roleMapper.selectRolesByUserId(userId);
//        StringBuffer idsStr = new StringBuffer();
//        for (SysRole role : list)
//        {
//            idsStr.append(role.getRoleName()).append(",");
//        }
//        if (StringUtils.isNotEmpty(idsStr.toString()))
//        {
//            return idsStr.substring(0, idsStr.length() - 1);
//        }
//        return idsStr.toString();
//    }

    /**
     * 查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
//    @Override
//    public String selectUserPostGroup(Long userId)
//    {
//        List<SysPost> list = postMapper.selectPostsByUserId(userId);
//        StringBuffer idsStr = new StringBuffer();
//        for (SysPost post : list)
//        {
//            idsStr.append(post.getPostName()).append(",");
//        }
//        if (StringUtils.isNotEmpty(idsStr.toString()))
//        {
//            return idsStr.substring(0, idsStr.length() - 1);
//        }
//        return idsStr.toString();
//    }

    /**
     * 用户状态修改
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int changeStatus(TbUser user)
    {
//        if (SysUser.isAdmin(user.getUserId()))
//        {
//            throw new BusinessException("不允许修改超级管理员用户");
//        }
        return userMapper.updateUser(user);
    }

    /**
     * 验证用户信息是否正确
     *
     * @param tbUser 用户信息
     * @return 结果
     */
    public Map<String, Object> verify(TbUser tbUser, boolean b) {
        if (b && tbUser.getUserId() == null) {
            return BaseMap.getFailureMap("数据不完整");
        }
        if (StringUtils.isBlank(tbUser.getLoginName()) || StringUtils.isBlank(tbUser.getPassword()) || tbUser.getOrganizeId() == null) {
            return R.error("数据不完整");
        }
        if (StringUtils.isNotBlank(tbUser.getPhonenumber())) {
            if (!PATTERN.matcher(tbUser.getPhonenumber()).matches()) {
                return R.error("新增用户'" + tbUser.getLoginName() + "'失败，手机号格式错误");
            }
        }
//        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(checkLoginNameUnique(tbUser.getLoginName(), userId))) {
//            return R.error("新增用户'" + tbUser.getLoginName() + "'失败，登录账号已存在");
//        }
        return BaseMap.getSuccessMap();
    }
}
