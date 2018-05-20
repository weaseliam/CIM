package com.cim.core.graveowner;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GraveownerRepository 
	extends PagingAndSortingRepository<Graveowner, Long>, JpaSpecificationExecutor<Graveowner>
{
	Graveowner findFirstByMarca(Long marca);
}
