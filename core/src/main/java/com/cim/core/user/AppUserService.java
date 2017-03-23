package com.cim.core.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional(readOnly = true)
public class AppUserService
{
	private static Logger logger = LoggerFactory.getLogger(AppUserService.class);
	
	@Autowired
	private AppUserRepository repository;
	
	public List<AppUser> listUsers()
	{
		List<AppUser> users = repository.findAll();
		logger.debug(users.toString());
		
		return users;
	}
}
