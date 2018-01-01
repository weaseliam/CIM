package com.cim.core.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;

@RestController
@RequestMapping(AppConstants.API_PATH + "/session")
public class SessionRest
{
	private static final Logger log = LoggerFactory.getLogger(SessionRest.class);
	
	private SessionService sessionService;
	
	@Autowired
	public SessionRest(SessionService sessionService)
	{
		Assert.notNull(sessionService, "sessionService must not be null");
		
		this.sessionService = sessionService;
	}
	
	@GetMapping
	public ResponseEntity<AppUserUi> getLoggedInUser()
	{
		log.debug("Fetching current logged in user");
		
		AppUser user = sessionService.getLoggedInUser();
		if (user == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		AppUserUi uiUser = SessionAssembler.toResource(user);
		
		log.debug("Response {}", uiUser);
		return ResponseEntity.ok(uiUser);
	}
}
