package com.cim.core.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppRest
{
	private static final Logger logger = LogManager.getLogger(AppRest.class);
	
    @RequestMapping("/")
    String toIndex() 
	{
    	logger.debug("Returning index.html for application root");
    	
        return "index.html";
    }
}
