package com.cim.core.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.cim.core.dictionary.DictionaryService;

public class AcceptLanguageHandlerMethodArgumentResolver extends HandlerMethodArgumentResolverComposite
{
	private static final Logger log = LoggerFactory.getLogger(AcceptLanguageHandlerMethodArgumentResolver.class);
	
	@Target(ElementType.PARAMETER)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface AcceptLanguage
	{
	}

	@Autowired
	private DictionaryService dictionaryService;
	
	@Override
	public boolean supportsParameter(MethodParameter parameter)
	{
		return parameter.getParameterType().equals(String.class)
				&& parameter.getParameterAnnotation(AcceptLanguage.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception
	{
		String acceptLanguage = webRequest.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
		log.debug("Browser request accept language {}", acceptLanguage);
		
		if (StringUtils.isBlank(acceptLanguage))
		{
			log.debug("Use service default language");
			return dictionaryService.getDefaultLanguage();
		}
		
		List<Locale.LanguageRange> list = Locale.LanguageRange.parse(acceptLanguage);
		Locale locale = Locale.lookup(list, dictionaryService.getSupportedLocales());
		
		if (locale == null)
		{
			log.debug("Use service default language");
			return dictionaryService.getDefaultLanguage();
		}
		
		log.debug("Use language {}", locale.getLanguage());
		return locale.getLanguage();
	}
}
