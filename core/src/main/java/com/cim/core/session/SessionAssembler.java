package com.cim.core.session;

import com.cim.core.session.user.AppUser;
import com.cim.core.session.user.AppUserUi;

public class SessionAssembler
{
	public static SessionUi toResource(AppUser user)
	{
		AppUserUi uiUser = new AppUserUi(user);
		SessionUi uiSession = new SessionUi();

		uiSession.setUser(uiUser);

		return uiSession;
	}
}
