package com.cim.core.session;

import com.cim.core.session.user.ApiAppUser;

public class ApiSession
{
	private ApiAppUser user;

	public ApiAppUser getUser()
	{
		return user;
	}

	public void setUser(ApiAppUser user)
	{
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "SessionUi [user=" + user + "]";
	}
}
