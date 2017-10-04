package com.cim.core.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cim.BaseRestTest;

public class AppUserServiceTest extends BaseRestTest
{
	@Autowired
	private AppUserService userService;
	
	@Test
	public void testListUsers()
	{
		List<AppUser> users = userService.listUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testAdminUser()
	{
		List<AppUser> users = userService.listUsers();
		
		boolean foundAdmin = false;
		for (AppUser user : users)
		{
			if (user.getUserName().equalsIgnoreCase("admin"))
			{
				foundAdmin = true;
				break;
			}
		}
		
		assertTrue(foundAdmin);
	}
}
