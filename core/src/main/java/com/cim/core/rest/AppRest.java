package com.cim.core.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppRest
{
	private static final Logger logger = LoggerFactory.getLogger(AppRest.class);

	@RequestMapping("/")
	String toIndex()
	{
		logger.debug("Returning index.html for application root");

		return "index.html";
	}
}
