package com.cim.core.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionConfig
{
	private static Logger logger = LoggerFactory.getLogger(ExceptionConfig.class);
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleGlobalException(Exception e, WebRequest request)
	{
		logger.error("Caught exception in global handler", e);
		return new ResponseEntity<Object>(new UiException(e), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
