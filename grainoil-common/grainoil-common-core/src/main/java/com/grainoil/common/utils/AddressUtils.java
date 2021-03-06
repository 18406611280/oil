package com.grainoil.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grainoil.common.json.JSON;
import com.grainoil.common.json.JSONObject;
import com.grainoil.common.utils.http.HttpUtils;

/**
 * 获取地址类
 * 
 * @author grainoil
 */
public class AddressUtils
{
    private static final Logger log    = LoggerFactory.getLogger(AddressUtils.class);

    public static final String  IP_URL = "http://region.zmrit.com";

    public static String getRealAddressByIP(String ip)
    {
        String address = "XX XX";
        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return "内网IP";
        }
        String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
        if (StringUtils.isEmpty(rspStr))
        {
            log.error("获取地理位置异常 {}", ip);
            return address;
        }
        JSONObject obj;
        try
        {
            obj = JSON.unmarshal(rspStr, JSONObject.class);
            JSONObject data = obj.getObj("data");
            address = data.getStr("address");
        }
        catch (Exception e)
        {
            log.error("获取地理位置异常 {}", ip);
        }
        return address;
    }
}
