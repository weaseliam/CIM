package com.cim.core.contract;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

import com.cim.core.util.ServiceListResponse;

public class ContractAssembler
{
	private ContractAssembler()
	{
		// private constructor
	}
	
	public static ApiContractList toResource(@NotNull ServiceListResponse<Contract> page)
	{
		ApiContractList response = new ApiContractList();
		response.setPage(page.getPage());
		response.setSize(page.getSize());
		response.setSort(page.getSort());
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalResults());
		
		List<ApiContract> contracts = page.getResponse().stream()
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
	
	public static ServiceListResponse<Contract> toServiceListResponse(@NotNull Page<Contract> page, String sort)
	{
		ServiceListResponse<Contract> response = new ServiceListResponse<Contract>();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		response.setResponse(page.getContent());
		
		return response;
	}
}
