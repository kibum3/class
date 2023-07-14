package com.project.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.exception.NotEnoughCoinException;
import com.project.exception.NotMyItemException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

	// 코인 부족 예외 처리
	@ExceptionHandler(NotEnoughCoinException.class)
	public String handleNotEnoughCoinException(NotEnoughCoinException ex, WebRequest request) {
		log.info("handleNotEnoughCoinException");
		
		return "redirect:/coin/notEnoughCoin";
	}
	
	// 본인 상품 예외 처리
	@ExceptionHandler(NotMyItemException.class)
	public String handleNotMyItemException(NotMyItemException ex, WebRequest request) {
		log.info("handleNotMyItemException");
		
		return "redirect:/useritem/notMyItem";
	}

	// 접근 거부 예외 처리
	@ExceptionHandler(AccessDeniedException.class)
	public void handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isAjax(request)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		else {
			throw ex;
		}
	}

	// 일반 예외 처리
	@ExceptionHandler(Exception.class)
	public String handle(Exception ex) {
		log.info("handle ex " + ex.toString());

		return "error/errorCommon";
	}

	public static boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}

}
