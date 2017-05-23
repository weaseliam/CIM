package com.cim.core.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppController;

@RestController
@RequestMapping(AppController.API_PATH + "/session")
public class SessionRest
{
	private static final Logger logger = LoggerFactory.getLogger(SessionRest.class);
	
	private SessionService sessionService;
	
	@Autowired
	public SessionRest(SessionService sessionService)
	{
		Assert.notNull(sessionService, "sessionService must not be null");
		
		this.sessionService = sessionService;
	}
	
	@GetMapping
	public AppUserUi getLoggedInUser()
	{
		AppUser user = sessionService.getLoggedInUser();
		AppUserUi uiUser = new AppUserUi(user);
		
		logger.debug("Response {}", uiUser);
		return uiUser;
	}
}
