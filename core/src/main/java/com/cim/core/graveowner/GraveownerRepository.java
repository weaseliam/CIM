package com.cim.core.graveowner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GraveownerRepository extends JpaRepository<Graveowner, Long>
{
	Graveowner findFirstByMarca(Long marca);
}
