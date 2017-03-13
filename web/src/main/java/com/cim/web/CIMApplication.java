package com.cim.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cim")
@SpringBootApplication
public class CIMApplication 
{
	private static final Logger logger = LogManager.getLogger(CIMApplication.class);
	
    public static void main(String[] args) throws Exception 
	{
    	logger.info("Staring application from Spring Boot main");
    	
        SpringApplication.run(CIMApplication.class, args);
    }
}
