package com.cim.web.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerConfig
{
	@RequestMapping("/")
	public String index()
	{
		return "index.html";
	}

	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
}
