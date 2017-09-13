package com.cheng.normal.base.domain;

import java.util.Date;

import com.sun.tools.javac.util.List;

/**
 * 用户实体类
 * @author cheng
 * @date 2017年8月16日  下午4:34:37
 */
public class Userinfo extends BaseDomain {
    private String username;

    private String password;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 性别(是否男)
     */
    private Boolean gender;
    /**
     * 手机号码
     */
    private Long phone;
    
    private String email;
    /**
     * 登录失败次数
     */
    private int failNumber;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    
    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    /**
     * 用户状态
     */
    private String status;
    /**
     * 位运算码(权限码)
     */
    private Long binaryCode;
    /**
     * 是否允许登录管理平台
     */
    private Boolean hasLoginMgr;

    private String remark;
    
    //===========添加字段=============
    private List<Role> roles;
    
    public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public int getFailNumber() {
        return failNumber;
    }

    public void setFailNumber(int failNumber) {
        this.failNumber = failNumber;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getBinaryCode() {
        return binaryCode;
    }

    public void setBinaryCode(Long binaryCode) {
        this.binaryCode = binaryCode;
    }

    public Boolean getHasLoginMgr() {
        return hasLoginMgr;
    }

    public void setHasLoginMgr(Boolean hasLoginMgr) {
        this.hasLoginMgr = hasLoginMgr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Userinfo() {
		super();
	}

	public Userinfo(String id,String username, String password, String realname, Boolean gender, Long phone, String email,
			int failNumber, Date lastLoginTime, String createUser, Date createTime, String updateUser, Date updateTime,
			String status, Long binaryCode, Boolean hasLoginMgr, String remark) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.failNumber = failNumber;
		this.lastLoginTime = lastLoginTime;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.status = status;
		this.binaryCode = binaryCode;
		this.hasLoginMgr = hasLoginMgr;
		this.remark = remark;
	}
}