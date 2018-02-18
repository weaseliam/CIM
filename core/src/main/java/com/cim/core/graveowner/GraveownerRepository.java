package com.cim.core.graveowner;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GraveownerRepository extends PagingAndSortingRepository<Graveowner, Long>
{
	Graveowner findFirstByMarca(Long marca);
}
