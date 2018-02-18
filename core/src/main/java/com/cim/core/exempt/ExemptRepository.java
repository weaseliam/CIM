package com.cim.core.exempt;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExemptRepository extends PagingAndSortingRepository<Exempt, Long>
{
	Exempt findFirstByCod(Integer cod);
}
