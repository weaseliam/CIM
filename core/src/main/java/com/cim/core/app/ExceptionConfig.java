package com.cim.core.app;

import java.util.Arrays;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
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
		
		Exception i18nEx = tryToI18N(e, request.getLocale());

		return new ResponseEntity<Object>(new UiException(i18nEx), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Exception tryToI18N(Exception e, Locale locale)
	{
		if (!(e instanceof AppException))
		{
			return e;
		}
		
		AppException appEx = (AppException) e;
		
		if (StringUtils.isBlank(appEx.getCode()) ||
			!StringUtils.isBlank(appEx.getMessage()) &&
				!StringUtils.equals(appEx.getCode(), appEx.getMessage()))
		{
			return appEx;
		}
		
		//TODO: perform English i18n based on code and params using dedicated service
		String i18nMessage = appEx.getCode() + Arrays.toString(appEx.getParams());
		
		return new AppException(appEx.getCode(), 
								appEx.getParams(), 
								i18nMessage, 
								appEx.getCause());
	}
}