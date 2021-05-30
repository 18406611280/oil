package com.grainoil.auth.service;

import java.util.HashMap;
import java.util.Map;

import com.grainoil.system.domain.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grainoil.common.constant.Constants;
import com.grainoil.common.redis.annotation.RedisEvict;
import com.grainoil.common.redis.util.RedisUtils;
import com.grainoil.system.domain.SysUser;

import cn.hutool.core.util.IdUtil;

@Service("accessTokenService")
public class AccessTokenService
{
    @Autowired
    private RedisUtils          redis;

    /**
     * 12小时后过期 (修改为一个月, 方便开发)
     */
    private final static long   EXPIRE        = 12 * 60 * 60;
//    private final static long   EXPIRE        = 30*24*60*60;

    private final static String ACCESS_TOKEN  = Constants.ACCESS_TOKEN;

    private final static String ACCESS_USERID = Constants.ACCESS_USERID;

    private final static String CURRENT_LQ = Constants.CURRENT_LQ;

    public SysUser queryByToken(String token)
    {
        return redis.get(ACCESS_TOKEN + token, SysUser.class);
    }

    /**
     * 生成token
     *
     * @param tbUser
     * @return
     */
    @RedisEvict(key = "user_perms", fieldKey = "#tbUser.userId")
    public Map<String, Object> createToken(TbUser tbUser) {
        // 生成token
        String token = IdUtil.fastSimpleUUID();
        // 保存或更新用户token
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", tbUser.getUserId());
        map.put("token", token);
        map.put("expire", EXPIRE);
        map.put("organizeType", tbUser.getOrganizeType());
        // expireToken(userId); // 加的话就表示一个用户同一时间只能一个会话,不加表示同一时间可以多个用户使用同一个账户
        redis.set(ACCESS_TOKEN + token, tbUser, EXPIRE);
        redis.set(ACCESS_USERID + tbUser.getUserId(), token, EXPIRE);
        redis.set(CURRENT_LQ + token, "", EXPIRE);
        return map;
    }

    /**
     * 退出时清除token
     *
     * @param userId
     */
    public void expireToken(long userId) {
        String token = redis.get(ACCESS_USERID + userId);
        if (StringUtils.isNotBlank(token)) {
            redis.delete(ACCESS_USERID + userId);
            redis.delete(ACCESS_TOKEN + token);
        }
    }
}