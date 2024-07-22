package com.gw.handler;

import java.nio.file.AccessDeniedException;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.gw.base.resp.ApiResp;
import com.gw.exception.AuthorityException;
import com.gw.exception.BusinessException;
import com.gw.exception.DecryptException;
import com.gw.exception.JWTExcepiton;
import com.gw.exception.LoginException;
import com.gw.exception.ParamException;
import com.gw.exception.UserStautsException;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 * @author 27669
 *
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler {
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ MethodArgumentNotValidException.class })
	public ApiResp<String> validationExceptionHandler(MethodArgumentNotValidException e) {
		String msg = e.getBindingResult().getFieldError().getDefaultMessage();
		return ApiResp.paramError(msg);
	}

	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ Exception.class })
	public ApiResp<String> exceptionHandler(Exception e) {
		log.error("", e);
		return ApiResp.sysError();
	}
	
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ LoginException.class })
	public ApiResp<String> loginHandler(LoginException e) {
		return ApiResp.authError(e.getMsg());
	}
	
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ AuthorityException.class })
	public ApiResp<String> authHandler(AuthorityException e) {
		return ApiResp.authError(e.getMsg());
	}
	
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ JWTExcepiton.class })
	public ApiResp<String> authHandler(JWTExcepiton e) {
		return ApiResp.jwtError(e.getMsg());
	}
	
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ AccessDeniedException.class })
	public ApiResp<String> accessDeniedHandler(AccessDeniedException e) {
		return ApiResp.authError("没有权限");
	}
	
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ BusinessException.class })
	public ApiResp<String> accessDeniedHandler(BusinessException e) {
		return ApiResp.bussError(e.getMsg());
	}
	@ResponseBody
	@SuppressWarnings("unchecked")
	@org.springframework.web.bind.annotation.ExceptionHandler({ UserStautsException.class })
	public ApiResp<String> userStautsExceptionHandler(UserStautsException e) {
		return ApiResp.bussError(e.getMsg());
	}
}
