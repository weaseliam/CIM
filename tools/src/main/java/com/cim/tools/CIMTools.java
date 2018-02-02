package com.cim.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cim")
@SpringBootApplication
public class CIMTools implements CommandLineRunner
{
	private static final Logger log = LoggerFactory.getLogger(CIMTools.class);

	@Override
	public void run(String... args) throws Exception
	{
		log.debug("Execute command '{}'", (Object[]) args);
	}

	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(CIMTools.class, args);
	}
}
