package com.grainoil.system.util;

import com.grainoil.common.utils.security.Md5Utils;
import com.grainoil.system.domain.SysUser;
import com.grainoil.system.domain.TbUser;

public class PasswordUtil {
//    public static boolean matches(SysUser user, String newPassword) {
//        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
//    }

    public static String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }

    public static boolean matches(TbUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getLoginName(), Base64Utils.decode(newPassword), user.getSalt()));
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtil.encryptPassword("byjt007", "admin123", "123456"));
    }
}