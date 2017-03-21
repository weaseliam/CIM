package com.cim.core.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppUser
{
	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString()
	{
		return "AppUser [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
}
