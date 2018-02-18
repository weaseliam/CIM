package com.cim.core.user;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService
{
	private static Logger		log	= LoggerFactory.getLogger(AppUserService.class);

	private AppUserRepository	userRepo;

	@Autowired
	public AppUserService(@NotNull AppUserRepository userRepo)
	{
		this.userRepo = userRepo;
	}

	public List<AppUser> listUsers()
	{
		List<AppUser> users = userRepo.findAll();
		log.debug("Got all app users {}", users.toString());

		return users;
	}
}
