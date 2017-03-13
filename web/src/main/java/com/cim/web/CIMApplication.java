package com.cim.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cim")
@SpringBootApplication
public class CIMApplication 
{
	private static final Logger logger = LoggerFactory.getLogger(CIMApplication.class);
	
    public static void main(String[] args) throws Exception 
	{
    	logger.info("Staring application from Spring Boot main");
    	
        SpringApplication.run(CIMApplication.class, args);
    }
}
