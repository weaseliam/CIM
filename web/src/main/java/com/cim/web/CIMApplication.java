package com.cim.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.cim")
@EnableJpaRepositories("com.cim")
@EntityScan("com.cim")
@SpringBootApplication
public class CIMApplication extends SpringBootServletInitializer
{
	private static final Logger log = LoggerFactory.getLogger(CIMApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		log.info("Running web application from external Server");
		
		return application.sources(CIMApplication.class);
	}

	public static void main(String[] args) throws Exception
	{
		log.info("Running web application from embedded Server");

		SpringApplication.run(CIMApplication.class, args);
	}
}
