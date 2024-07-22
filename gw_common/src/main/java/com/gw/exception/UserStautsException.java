package com.gw.exception;

import lombok.Getter;

/** 
* @author yangxy
* @version 创建时间：2023年9月11日 上午10:09:56 
*/
@Getter
public class UserStautsException extends RuntimeException {
	private String msg;

	public UserStautsException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
