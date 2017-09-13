package com.cheng.normal.base.util;

public class JSONResult {
	private boolean success = true;
	private String msg;

	public void mark(String errMsg) {
		this.success = false;
		this.msg = errMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
