package com.grainoil.auth.controller;

import javax.servlet.http.HttpServletRequest;

import com.grainoil.system.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.service.CaptchaService;
import com.grainoil.auth.form.LoginForm;
import com.grainoil.auth.service.AccessTokenService;
import com.grainoil.auth.service.SysLoginService;
import com.grainoil.common.core.domain.R;
import com.grainoil.system.domain.SysUser;

@RestController
public class TokenController {
    @Autowired
    private AccessTokenService tokenService;

    @Autowired
    private SysLoginService    sysLoginService;

    @Autowired
    private CaptchaService     captchaService;

    /**
     * 无滑块方式的登录
     * @param form
     * @return
     */
    @PostMapping("login")
    public R login(@RequestBody LoginForm form) {
        // 用户登录
        TbUser user = sysLoginService.login(form.getUsername(), form.getPassword());
        // 获取登录token
        return R.ok(tokenService.createToken(user));
    }

    /**
     * 验证滑块的登录
     * @param form
     * @return
     */
    @PostMapping("login/slide")
    public R loginSilde(@RequestBody LoginForm form) {
        ResponseModel response = captchaService.verification(form.getCaptchaVO());
        if (response.isSuccess()) {
            // 用户登录
            TbUser user = sysLoginService.login(form.getUsername(), form.getPassword());
            // 获取登录token
            return R.ok(tokenService.createToken(user));
        }
        return R.error().put("repCode", response.getRepCode());
    }

    @PostMapping("logout")
    public R logout(HttpServletRequest request) {
        String token=request.getHeader("token");
        SysUser user=tokenService.queryByToken(token);
        if (null != user) {
            sysLoginService.logout(user.getLoginName());
            tokenService.expireToken(user.getUserId());
        }
        return R.ok();
    }
}
