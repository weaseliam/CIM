package com.cim.core.security;

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
	@Bean
	@Profile(Profiles.DEVELOPMENT)
	WebSecurityConfigurerAdapter noAuth()
	{
		return new WebSecurityConfigurerAdapter()
		{
			@Override
			public void configure(HttpSecurity http) throws Exception
			{
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
				http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().httpBasic();
			}

			@Override
			public void configure(AuthenticationManagerBuilder auth) throws Exception
			{
				auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
			}
		};
	}
}
