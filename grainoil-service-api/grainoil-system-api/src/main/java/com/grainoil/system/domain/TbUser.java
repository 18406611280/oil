package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

import java.util.List;
import java.util.Map;

public class TbUser extends BaseEntity {

    private static final long   serialVersionUID = 1L;
    /**
    * 用户id
    */
    private Long userId;

    /**
    * 登录账号
    */
    private String loginName;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 手机号
    */
    private String phonenumber;

    /**
    * 所属市区级的组织id,数据权限id，便于后续管理查询
    */
    private Long organizeId;

    /**
     * 所属部门或者单位id
     */
    private Long organizeDepotId;

    /**
    * 组织类型
    */
    private String organizeType;

    /**
    * 性别
    */
    private String sex;

    /**
    * 身份证号
    */
    private String identification;

    /**
    * 密码
    */
    private String password;

    /**
    * 盐加密
    */
    private String salt;

    /**
    * 状态(0正常 1停用)
    */
    private String state;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;

    /**
     * 角色信息
     */
    private List<TbRole> roles;

    /**
     * 菜单按钮信息
     */
    private List<Map<String, Object>> menus;

    /**
     * 粮权信息
     */
    private List<Map<String, Object>> lq;

    /**
     * 组织信息
     */
    private TbOrganize organize;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeType() {
        return organizeType;
    }

    public void setOrganizeType(String organizeType) {
        this.organizeType = organizeType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getOrganizeDepotId() {
        return organizeDepotId;
    }

    public void setOrganizeDepotId(Long organizeDepotId) {
        this.organizeDepotId = organizeDepotId;
    }

    public List<TbRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TbRole> roles) {
        this.roles = roles;
    }

    public List<Map<String, Object>> getMenus() {
        return menus;
    }

    public void setMenus(List<Map<String, Object>> menus) {
        this.menus = menus;
    }

    public List<Map<String, Object>> getLq() {
        return lq;
    }

    public void setLq(List<Map<String, Object>> lq) {
        this.lq = lq;
    }

    public TbOrganize getOrganize() {
        return organize;
    }

    public void setOrganize(TbOrganize organize) {
        this.organize = organize;
    }
}