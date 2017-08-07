package com.cim.core.user;

public class SessionAssembler
{
	public static AppUserUi toResource(AppUser user)
	{
		AppUserUi uiUser = new AppUserUi(user);
		
		return uiUser;
	}
}
