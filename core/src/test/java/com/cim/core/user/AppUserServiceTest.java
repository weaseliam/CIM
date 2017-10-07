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
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Test
	public void testListUsers()
	{
		List<AppUser> users = userService.listUsers();
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testPredefinedAdminUser()
	{
		List<AppUser> users = userService.listUsers();
		
		boolean found = false;
		for (AppUser user : users)
		{
			if ("admin".equals(user.getUserName()))
			{
				found = true;
				break;
			}
		}
		
		assertTrue(found);
	}
	
	@Test
	public void testNewlyAddedUser()
	{
		addNewUser("john_doe", "1234", "John", "Doe");

		List<AppUser> users = userService.listUsers();
		
		boolean found = false;
		for (AppUser user : users)
		{
			if ("john_doe".equals(user.getUserName()))
			{
				found = true;
				break;
			}
		}
		
		assertTrue(found);
	}
	
	private void addNewUser(String userName, String passWord, String firstName, String lastName)
	{
		AppUser user = new AppUser();
		user.setUserName(userName);
		user.setPassword(passWord);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		userRepository.save(user);
	}
}
