package com.cim.core.status;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.cim.core.contract.ContractFull;
import com.cim.core.util.ApiListResponse;
import com.cim.core.util.ServiceListResponse;

public class StatusAssembler
{
	private StatusAssembler()
	{
		// private constructor
	}

	public static ApiListResponse<ApiContractStatus> toResource(@NotNull ServiceListResponse<ContractFull> page)
	{
		ApiListResponse<ApiContractStatus> response = new ApiListResponse<>();
		response.setPage(page.getPage());
		response.setSize(page.getSize());
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalResults());
		
		List<ApiContractStatus> contractStatuses = page.getResults().stream()
				.map(contract -> new ApiContractStatus(contract))
				.collect(Collectors.toList());
		response.setResults(contractStatuses);
		
		return response;
	}
}
