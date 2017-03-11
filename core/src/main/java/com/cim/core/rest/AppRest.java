package com.cim.core.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRest
{
    @RequestMapping("/")
    String home() 
	{
        return "Hello World !";
    }
}
