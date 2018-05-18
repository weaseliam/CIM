package com.cim.core.session;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cim.core.app.AppException;
import com.cim.core.session.user.AppUser;
import com.cim.core.session.user.AppUserRepository;

@Service
public class SessionService
{
	private static Logger		log	= LoggerFactory.getLogger(SessionService.class);

	private AppUserRepository	userRepo;

	@Autowired
	public SessionService(@NotNull AppUserRepository userRepo)
	{
		this.userRepo = userRepo;
	}

	public AppUser getLoggedInUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null)
		{
			throw new AppException("security.context.auth.error");
		}

		String userName = auth.getName();
		AppUser user = userRepo.findByUserNameIgnoreCase(userName);

		log.debug("Got logged in user {}", user);
		return user;
	}
}
