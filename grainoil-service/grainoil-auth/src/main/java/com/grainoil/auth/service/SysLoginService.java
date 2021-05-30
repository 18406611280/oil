package com.grainoil.auth.service;

import com.grainoil.system.domain.TbUser;
import com.grainoil.system.util.Base64Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grainoil.common.constant.Constants;
import com.grainoil.common.constant.UserConstants;
import com.grainoil.common.enums.UserStatus;
import com.grainoil.common.exception.user.UserBlockedException;
import com.grainoil.common.exception.user.UserDeleteException;
import com.grainoil.common.exception.user.UserNotExistsException;
import com.grainoil.common.exception.user.UserPasswordNotMatchException;
import com.grainoil.common.log.publish.PublishFactory;
import com.grainoil.common.utils.DateUtils;
import com.grainoil.common.utils.IpUtils;
import com.grainoil.common.utils.MessageUtils;
import com.grainoil.common.utils.ServletUtils;
import com.grainoil.system.domain.SysUser;
import com.grainoil.system.feign.RemoteUserService;
import com.grainoil.system.util.PasswordUtil;

@Component
public class SysLoginService {

    @Autowired
    private RemoteUserService  userService;

    /**
     * 登录验证
     */
    public TbUser login(String username, String password)
    {
        // 验证码校验
        // if
        // (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA)))
        // {
        // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username,
        // Constants.LOGIN_FAIL,
        // MessageUtils.message("user.jcaptcha.error")));
        // throw new CaptchaException();
        // }
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password)) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null"));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (Base64Utils.decode(password).length() < UserConstants.PASSWORD_MIN_LENGTH || Base64Utils.decode(password).length() > UserConstants.PASSWORD_MAX_LENGTH) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }
        // 查询用户信息
        TbUser user = userService.selectSysUserByUsername(username);
        if (user == null) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists"));
            throw new UserNotExistsException();
        }
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.delete"));
            throw new UserDeleteException();
        }
        if (UserStatus.DISABLE.getCode().equals(user.getState())) {
            PublishFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark()));
            throw new UserBlockedException();
        }
        if (!PasswordUtil.matches(user, password))
        {
            throw new UserPasswordNotMatchException();
        }
        PublishFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success"));
//        recordLoginInfo(user);
        return user;
    }


    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUser user) {
        user.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserLoginRecord(user);
    }

    /**
     * 记录退出日志
     * @param loginName
     */
    public void logout(String loginName) {
//        PublishFactory.recordLogininfor(loginName, Constants.LOGOUT, MessageUtils.message("user.logout.success"));
    }
}