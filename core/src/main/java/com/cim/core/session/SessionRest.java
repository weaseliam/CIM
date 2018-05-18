package com.cim.core.session;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;
import com.cim.core.session.user.AppUser;

@RestController
@RequestMapping(AppConstants.API_PATH + "/session")
public class SessionRest
{
	private static final Logger	log	= LoggerFactory.getLogger(SessionRest.class);

	private SessionService		sessionService;

	@Autowired
	public SessionRest(@NotNull SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	@GetMapping
	public ResponseEntity<SessionUi> getSession()
	{
		log.debug("Fetching session");

		AppUser user = sessionService.getLoggedInUser();
		if (user == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		SessionUi uiSession = SessionAssembler.toResource(user);

		log.debug("Response {}", uiSession);
		return ResponseEntity.ok(uiSession);
	}
}
