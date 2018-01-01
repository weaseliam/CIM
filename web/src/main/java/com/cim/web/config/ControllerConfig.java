package com.cim.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerConfig
{
	private static final Logger log = LoggerFactory.getLogger(ControllerConfig.class);

	@RequestMapping("/")
	public String index()
	{
		log.debug("Returning index for application root");

		return "index.html";
	}

	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
}
