package com.cim.core.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AppUserService
{
	private static Logger log = LoggerFactory.getLogger(AppUserService.class);
	
	private AppUserRepository userRepo;
	
	@Autowired
	public AppUserService(AppUserRepository userRepo)
	{
		Assert.notNull(userRepo, "userRepo must not be null");
		
		this.userRepo = userRepo;
	}
	
	public List<AppUser> listUsers()
	{
		List<AppUser> users = userRepo.findAll();
		log.debug("Got all app users {}", users.toString());
		
		return users;
	}
}
