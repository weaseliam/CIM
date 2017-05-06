package com.cim.core.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
	public AppUser findByUserNameIgnoreCase(String userName);
}
