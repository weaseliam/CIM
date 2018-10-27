package com.cim.core.session;

import com.cim.core.session.user.ApiAppUser;
import com.cim.core.session.user.AppUser;

public class SessionAssembler
{
	public SessionAssembler()
	{
		// private constructor
	}
	
	public static ApiSession toResource(AppUser user)
	{
		ApiAppUser uiUser = new ApiAppUser(user);
		ApiSession uiSession = new ApiSession();

		uiSession.setUser(uiUser);

		return uiSession;
	}
}
