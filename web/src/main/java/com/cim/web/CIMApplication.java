package com.cim.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cim")
@SpringBootApplication
public class CIMApplication 
{
    public static void main(String[] args) throws Exception 
	{
        SpringApplication.run(CIMApplication.class, args);
    }
}
