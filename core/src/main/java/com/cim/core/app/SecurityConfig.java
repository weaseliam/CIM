package com.cim.core.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.cim.core.user.AppUser;
import com.cim.core.user.AppUserService;

@EnableWebSecurity
class SecurityConfig
{
	private static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private AppUserService userService;

	@Bean
	public UserDetailsService userDetailsService() throws Exception
	{
		List<AppUser> users = userService.listUsers();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		for (AppUser user : users)
		{
			String userName = user.getUserName();
			String password = user.getPassword();
			manager.createUser(User
					.withUsername(userName)
					.password(password)
					.roles("USER").build());
		}

		return manager;
	}

	@Configuration
	@Order(1)
	@Profile(AppProfiles.PRODUCTION)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter
	{
		protected void configure(HttpSecurity http) throws Exception
		{
			log.info("Running PRODUCTION rest api security configuration");

			http
				.antMatcher(AppController.API_PATH + "/**")
					.authorizeRequests()
						.anyRequest()
						.hasRole("USER")
						.and()
					.httpBasic();
		}
	}

	@Configuration
	@Profile(AppProfiles.PRODUCTION)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter
	{
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			log.info("Running PRODUCTION security configuration");

			http
				.authorizeRequests()
					.antMatchers("/templates/**").permitAll()
					.anyRequest().fullyAuthenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/logout")
					.deleteCookies("JSESSIONID")
					.invalidateHttpSession(true)
					.logoutSuccessUrl("/login?logout")
					.and()
				.sessionManagement()
					.sessionFixation()
					.newSession()
					.maximumSessions(1)
					.expiredUrl("/login");

			// TODO: Remove these in the future
			http.csrf().disable();
			http.headers().frameOptions().sameOrigin();
		}
	}

	@Configuration
	@Profile(AppProfiles.DEVELOPMENT)
	public static class DevWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter
	{
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			log.info("Running DEVELOPMENT security configuration");

			http
				.authorizeRequests()
					.anyRequest()
					.permitAll();
		}
	}
}
