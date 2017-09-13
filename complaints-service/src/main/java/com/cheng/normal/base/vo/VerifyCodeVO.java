package com.cheng.normal.base.vo;

import java.util.Date;

//封装手机验证码,手机号码,发送时间的信息
public class VerifyCodeVO {
	private String code;
	private String phoneNumber;
	private Date sendTime;
	
	public VerifyCodeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerifyCodeVO(String code, String phoneNumber, Date sendTime) {
		super();
		this.code = code;
		this.phoneNumber = phoneNumber;
		this.sendTime = sendTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	
}
