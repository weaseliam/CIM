package com.cim.core.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppRest
{
	private static final Logger logger = LoggerFactory.getLogger(AppRest.class);

	public static final String API_PATH	= "/api";

	@RequestMapping("/")
	public String handleIndex()
	{
		logger.debug("Returning index for application root");

		return "index.html";
	}
}
