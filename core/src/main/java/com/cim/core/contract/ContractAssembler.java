package com.cim.core.contract;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

public class ContractAssembler
{
	private ContractAssembler()
	{
		// private constructor
	}
	
	public static ApiContractList toResource(@NotNull Page<Contract> page, String sort)
	{
		ApiContractList response = new ApiContractList();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		
		List<ApiContract> contracts = page.getContent().stream()
				.map(contract -> new ApiContract(contract))
				.collect(Collectors.toList());
		response.setContracts(contracts);
		
		return response;
	}

	public static ContractFilter fromResource(Long graveownerId)
	{
		if (graveownerId == null)
		{
			return null;
		}

		ContractFilter filter = new ContractFilter.Builder()
				.setGraveownerId(graveownerId)
				.build();

		return filter;
	}
}
