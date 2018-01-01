package com.cim.web.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cim.core.app.AcceptLanguageHandlerMethodArgumentResolver;
import com.cim.core.app.AppConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WebConfig extends WebMvcConfigurerAdapter
{
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)
	{
		argumentResolvers.add(acceptLanguageHandler());
	}
    
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(new ApiInfoBuilder()
						.title("CIM REST API")
						.build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cim"))
				.paths(PathSelectors.ant(AppConstants.API_PATH + "/*"))
				.build();
	}
	
	@Bean
	public AcceptLanguageHandlerMethodArgumentResolver acceptLanguageHandler()
	{
		return new AcceptLanguageHandlerMethodArgumentResolver();
	}
}
