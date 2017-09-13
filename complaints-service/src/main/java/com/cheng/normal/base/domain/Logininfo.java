package com.cheng.normal.base.domain;

import java.util.Date;

import com.sun.tools.javac.util.List;

/**
 * @author cheng
 * @date 2017年8月22日  下午3:55:36
 */
public class Logininfo extends BaseDomain {

	private String username;
	
	private boolean gender;
	
	private int failNumber;
	
	private Date lastLoginTime;
	
	private String status;
	/**
     * 位运算码(权限码)
     */
	private Long binaryCode;
	/**
     * 是否允许登录管理平台
     */
    private Boolean hasLoginMgr;
    
    private List<Role> roles;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
