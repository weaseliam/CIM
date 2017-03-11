package com.cim.core.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppRest
{
    @RequestMapping("/")
    String toIndex() 
	{
        return "index.html";
    }
}
