package com.cim.core.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cim.core.user.AppUser;
import com.cim.core.user.AppUserService;

@Configuration
@EnableWebSecurity
class SecurityConfig
{
	private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Bean
	@Profile(AppProfiles.DEVELOPMENT)
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
	@Profile(AppProfiles.PRODUCTION)
	WebSecurityConfigurerAdapter basic()
	{
		return new WebSecurityConfigurerAdapter()
		{
			@Autowired
			private AppUserService userService;
			
			@Override
			public void configure(HttpSecurity http) throws Exception
			{
				logger.info("Running PRODUCTION security configuration");
				
				http
					.authorizeRequests()
						.anyRequest().fullyAuthenticated()
						.and()
					.formLogin()
						.loginPage("/login")
						.permitAll()
						.and()
					.httpBasic()
						.and()
					.logout()
						.logoutUrl("/logout")
						.deleteCookies("JSESSIONID")
						.invalidateHttpSession(true)
						.logoutSuccessUrl("/login")
//						.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
						.and()
		            .sessionManagement()
			            .sessionFixation()
			            .newSession()
		                .maximumSessions(1)
//		                .maxSessionsPreventsLogin(true)
		                .expiredUrl("/login");
				
				// TODO: Remove these in the future
				http.csrf().disable();
				http.headers().frameOptions().sameOrigin();
			}

			@Override
			public void configure(AuthenticationManagerBuilder auth) throws Exception
			{
				List<AppUser> users = userService.listUsers();
				
				for (AppUser user : users)
				{
					String userName = user.getUserName();
					String password = user.getPassword();
					auth.inMemoryAuthentication().withUser(userName).password(password).roles("USER");
				}
			}
		};
	}
}
