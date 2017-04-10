package com.cim.core.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppUserServiceTest
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
