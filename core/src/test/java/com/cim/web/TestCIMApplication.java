package com.cim.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.cim")
@EnableJpaRepositories("com.cim")
@EntityScan("com.cim")
@SpringBootApplication
public class TestCIMApplication 
{
	private static final Logger logger = LoggerFactory.getLogger(TestCIMApplication.class);
	
    public static void main(String[] args) throws Exception 
	{
    	logger.info("Staring application for TEST");
    	
        SpringApplication.run(TestCIMApplication.class, args);
    }
}
