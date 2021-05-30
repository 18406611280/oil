package com.grainoil.system.controller.application_supporting_platform;

import com.grainoil.common.annotation.LoginUser;
import com.grainoil.common.constant.UserConstants;
import com.grainoil.common.core.controller.BaseController;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.utils.RandomUtil;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbUser;
import com.grainoil.system.service.ITbMenuService;
import com.grainoil.system.service.ITbOrganizeLqService;
import com.grainoil.system.service.ITbUserService;
import com.grainoil.system.util.PasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户 提供者
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class TbUserController extends BaseController {

    @Autowired
    ITbUserService tbUserService;

    @Autowired
    private ITbMenuService tbMenuService;

    @Autowired
    private ITbOrganizeLqService organizeLqService;

    /**
     * 根据id查询用户
     */
    @GetMapping("get/{userId}")
    public TbUser get(@PathVariable("userId") Long userId) {
        return tbUserService.selectUserById(userId);
    }

    @GetMapping("info")
    @ApiOperation("查询用户和权限信息")
    public R info(@ApiIgnore @LoginUser TbUser tbUser) {
        tbUser.setMenus(tbMenuService.getMenu(tbUser.getRoles()));
        tbUser.setLq(organizeLqService.getLq(tbUser.getOrganizeId()));
        return R.data(tbUser);
    }

    /**
     * 根据登录名查询用户(远程调用用到)
     *
     * @param loginName 登录名
     * @return 用户信息
     */
    @GetMapping("find/{loginName}")
    public TbUser findByUsername(@PathVariable("loginName") String loginName) {
        return tbUserService.selectUserByLoginName(loginName);
    }

    /**
     * 查询用户列表
     */
    @GetMapping("list")
    public R list(TbUser tbUser) {
        startPage();
        return result(tbUserService.selectUserList(tbUser));
    }

    /**
     * 新增保存用户
     */
    @PostMapping("insert")
//    @OperLog(title = "用户管理", businessType = BusinessType.INSERT)
    public R insert(@RequestBody TbUser tbUser) {
        tbUser.setSalt(RandomUtil.randomStr(6));
        tbUser.setPassword(PasswordUtil.encryptPassword(tbUser.getLoginName(), tbUser.getPassword(), tbUser.getSalt()));
        tbUser.setCreateBy(getLoginName());
        tbUser.setCreateId(getCurrentUserId());
        tbUser.setUpdateId(getCurrentUserId());
        tbUser.setUpdateBy(getLoginName());
        return tbUserService.insertUser(tbUser);
    }

    /**
     * 修改保存用户
     */
//    @OperLog(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("update")
    public R editSave(@RequestBody TbUser tbUser) {
        return tbUserService.updateUser(tbUser);
    }

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    @PostMapping("update/info")
//    @OperLog(title = "用户管理", businessType = BusinessType.UPDATE)
    public R updateInfo(@RequestBody TbUser sysUser)
    {
        return toAjax(tbUserService.updateUserInfo(sysUser));
    }

    /**
     * 记录登陆信息
     * @param sysUser
     * @return
     */
//    @PostMapping("update/login")
//    public R updateLoginRecord(@RequestBody SysUser sysUser)
//    {
//        return toAjax(sysUserService.updateUser(sysUser));
//    }

//    @OperLog(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    public R resetPwdSave(@RequestBody TbUser user)
    {
        if (null != user.getUserId())
        {
            return R.error("不允许修改超级管理员用户");
        }
        user.setSalt(RandomUtil.randomStr(6));
        user.setPassword(PasswordUtil.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        return toAjax(tbUserService.resetUserPwd(user));
    }

//    @OperLog(title = "修改密码", businessType = BusinessType.UPDATE)
    @PostMapping("/updatePwd")
    public R updatePwdSave(@RequestBody TbUser user)
    {
        Long userId = getCurrentUserId();
        user.setUserId(userId);
        user.setSalt(RandomUtil.randomStr(6));
        user.setPassword(PasswordUtil.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        return toAjax(tbUserService.resetUserPwd(user));
    }

    /**
     * 修改状态
     * @param user
     * @return
     */
    @PostMapping("status")
//    @OperLog(title = "用户管理", businessType = BusinessType.UPDATE)
    public R status(@RequestBody TbUser user)
    {
        if (null != user.getUserId())
        {
            return R.error("不允许修改超级管理员用户");
        }
        return toAjax(tbUserService.changeStatus(user));
    }

    /**
     * 删除用户
     */
//    @OperLog(title = "用户管理", businessType = BusinessType.DELETE)
//    @PostMapping("remove")
//    public R remove(String ids)
//    {
//        return toAjax(tbUserService.deleteUserByIds(ids));
//    }
}
