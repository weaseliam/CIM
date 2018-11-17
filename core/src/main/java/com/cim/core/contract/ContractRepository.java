package com.cim.core.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository 
	extends PagingAndSortingRepository<Contract, Long>, JpaSpecificationExecutor<Contract>
{
	List<Contract> findAllByOldId(Long id);
}
