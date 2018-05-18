package com.cim.core.session.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
	public AppUser findByUserNameIgnoreCase(String userName);
}
