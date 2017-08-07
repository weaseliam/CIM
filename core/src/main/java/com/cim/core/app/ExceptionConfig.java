package com.cim.core.app;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cim.core.dictionary.DictionaryService;

@ControllerAdvice
public class ExceptionConfig
{
	private static Logger log = LoggerFactory.getLogger(ExceptionConfig.class);

	private DictionaryService dictionaryService;
	
	@Autowired
	ExceptionConfig(DictionaryService dictionaryService)
	{
		Assert.notNull(dictionaryService, "dictionaryService must not be null");
		
		this.dictionaryService = dictionaryService;
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<UiException> handleGlobalException(Exception e, WebRequest request)
	{
		log.error("Caught exception in global handler", e);
		
		Exception i18nEx = tryToI18N(e, request.getLocale());

		return new ResponseEntity<UiException>(new UiException(i18nEx), HttpStatus.INTERNAL_SERVER_ERROR);
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
		
		String i18nMessage = dictionaryService.getMessage(appEx.getCode(), appEx.getParams());
		
		return new AppException(appEx.getCode(), 
								appEx.getParams(), 
								i18nMessage, 
								appEx.getCause());
	}
}
