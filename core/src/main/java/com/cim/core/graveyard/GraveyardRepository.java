package com.cim.core.graveyard;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GraveyardRepository extends PagingAndSortingRepository<Graveyard, Long>
{
	Graveyard findFirstByNume(String nume);
}
