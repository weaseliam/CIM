package com.cim.core.session;

import com.cim.core.session.user.AppUserUi;

public class SessionUi
{
	private AppUserUi user;

	public AppUserUi getUser()
	{
		return user;
	}

	public void setUser(AppUserUi user)
	{
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "SessionUi [user=" + user + "]";
	}
}
