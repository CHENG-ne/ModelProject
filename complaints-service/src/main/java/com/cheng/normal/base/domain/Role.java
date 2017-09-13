package com.cheng.normal.base.domain;

import java.util.Date;

public class Role extends BaseDomain {
    private Integer roleId;

    private String roleName;

    private Integer leval;

    private String tag;

    private Integer parentId;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Boolean allowModify;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getLeval() {
        return leval;
    }

    public void setLeval(Integer leval) {
        this.leval = leval;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public Boolean getAllowModify() {
        return allowModify;
    }

    public void setAllowModify(Boolean allowModify) {
        this.allowModify = allowModify;
    }

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer roleId, String roleName, Integer leval, String tag, Integer parentId, String createUser, Date createTime, String updateUser, Date updateTime,
			Boolean allowModify) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.leval = leval;
		this.tag = tag;
		this.parentId = parentId;
		this.createUser = createUser;
		this.createTime = createTime;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.allowModify = allowModify;
	}
    
}