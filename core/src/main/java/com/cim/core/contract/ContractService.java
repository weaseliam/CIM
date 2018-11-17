package com.cim.core.contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cim.core.util.RestUtil;

@Service
public class ContractService
{
	private ContractRepository contractRepository;

	@Autowired
	public ContractService(@NotNull ContractRepository contractRepository)
	{
		this.contractRepository = contractRepository;
	}

	public List<Contract> save(List<Contract> contracts)
	{
		List<Contract> savedContracts = new ArrayList<>();
		for (Contract contract : contractRepository.saveAll(contracts))
		{
			savedContracts.add(contract);
		}
		
		return Collections.unmodifiableList(savedContracts);
	}
	
	public List<Contract> findAllByOldId(long id)
	{
		return contractRepository.findAllByOldId(id);
	}
	
	public Page<Contract> list(int page, int size, String sort, ContractFilter filter)
	{
		Specification<Contract> spec = ContractSpecifications.buildFilterSpec(filter);
		
		PageRequest pageRequest = PageRequest.of(
				Math.max(page - 1, 0), 
				Math.max(size, 1), 
				RestUtil.toServiceSort(sort));
		
		Page<Contract> contracts = contractRepository.findAll(spec, pageRequest);
		
		return contracts;
	}
}
