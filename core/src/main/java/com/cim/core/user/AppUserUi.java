package com.cim.core.user;

import javax.validation.constraints.NotNull;

public class AppUserUi
{
	private String	userName;

	private String	firstName;

	private String	lastName;

	private String	email;

	public AppUserUi(@NotNull AppUser appUser)
	{
		setUserName(appUser.getUserName());
		setFirstName(appUser.getFirstName());
		setLastName(appUser.getLastName());
		setEmail(appUser.getEmail());
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "AppUserUi [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}
}
