package com.cim.core.grave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GraveRepository 
	extends PagingAndSortingRepository<Grave, Long>, JpaSpecificationExecutor<Grave>
{
	List<Grave> findAllByOldId(Long id);
}
