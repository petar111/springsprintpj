package com.springteam.springsprintpj.errorhandler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springteam.springsprintpj.errorhandler.dto.ErrorBody;
import com.springteam.springsprintpj.model.exception.hero.HeroNotFoundException;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ HeroNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(HeroNotFoundException ex, WebRequest request) {

		return handleExceptionInternal(ex,
				ErrorBody.builder().status(HttpStatus.BAD_REQUEST).message(ex.getMessage())
						.stackTrace(ExceptionUtils.getStackTrace(ex)).build(),
				new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {

		return handleExceptionInternal(ex,
				ErrorBody.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage())
						.stackTrace(ExceptionUtils.getStackTrace(ex)).build(),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
