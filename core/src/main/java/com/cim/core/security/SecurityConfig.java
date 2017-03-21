package com.cim.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cim.core.app.Profiles;

@Configuration
@EnableWebSecurity
class SecurityConfig
{
	private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Bean
	@Profile(Profiles.DEVELOPMENT)
	WebSecurityConfigurerAdapter noAuth()
	{
		return new WebSecurityConfigurerAdapter()
		{
			@Override
			public void configure(HttpSecurity http) throws Exception
			{
				logger.info("Running DEVELOPMENT security configuration");
				
				http.authorizeRequests().anyRequest().permitAll();
			}
		};
	}

	@Bean
	@Profile(Profiles.PRODUCTION)
	WebSecurityConfigurerAdapter basic()
	{
		return new WebSecurityConfigurerAdapter()
		{
			@Override
			public void configure(HttpSecurity http) throws Exception
			{
				logger.info("Running PRODUCTION security configuration");
				
				http
					.authorizeRequests()
					.antMatchers("/").permitAll()
					.anyRequest()
					.authenticated()
					.and()
				.httpBasic()
					.and()
				.logout()
					.permitAll();
				
				// TODO: Remove these in the future
				http.csrf().disable();
				http.headers().frameOptions().sameOrigin();
			}

			@Override
			public void configure(AuthenticationManagerBuilder auth) throws Exception
			{
				auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
			}
		};
	}
}
