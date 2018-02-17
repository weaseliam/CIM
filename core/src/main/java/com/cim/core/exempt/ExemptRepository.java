package com.cim.core.exempt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemptRepository extends JpaRepository<Exempt, Long>
{
	Exempt findFirstByCod(Integer cod);
}
