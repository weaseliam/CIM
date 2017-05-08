package com.cim.core.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cim.core.app.AppException;

@Service
@Repository
@Transactional(readOnly = true)
public class SessionService
{
	private static Logger logger = LoggerFactory.getLogger(SessionService.class);
	
	private AppUserRepository userRepo;
	
	@Autowired
	public SessionService(AppUserRepository userRepo)
	{
		Assert.notNull(userRepo, "userRepo must not be null");
		
		this.userRepo = userRepo;
	}
	
	public AppUser getLoggedInUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Assert.notNull(auth, "Spring security context authentication must not be null");
		
		String userName = auth.getName();
		AppUser user = userRepo.findByUserNameIgnoreCase(userName);
		if (user == null)
		{
			throw new AppException("session.user.notFoundInDB");
		}
		
		logger.debug("Got logged in user {}", user);
		
		return user;
	}
}
