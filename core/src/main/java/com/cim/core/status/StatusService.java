package com.cim.core.status;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cim.core.contract.ContractFilter;
import com.cim.core.contract.ContractFull;
import com.cim.core.contract.ContractService;
import com.cim.core.util.ServiceListResponse;

@Service
public class StatusService
{
	private ContractService contractService;
	
	@Autowired
	public StatusService(@NotNull ContractService contractService)
	{
		this.contractService = contractService;
	}
	
	public ServiceListResponse<ContractFull> listContractsFull(int page, int size, int daysTillExpiration)
	{
		ContractFilter filter = buildContractsExpirationFilter(daysTillExpiration);
		ServiceListResponse<ContractFull> contracts = contractService.listFull(page, size, "dataExp", filter);
		
		return contracts;
	}

	private ContractFilter buildContractsExpirationFilter(int daysTillExpiration)
	{
		ContractFilter filter;
		LocalDateTime today = LocalDateTime.now();
		
		if (daysTillExpiration <= 0)
		{
			filter = new ContractFilter.Builder()
					.setDataExpLt(today)
					.build();
		}
		else
		{
			filter = new ContractFilter.Builder()
					.setDataExpGt(today)
					.setDataExpLt(today.plusDays(daysTillExpiration))
					.build();
		}
		return filter;
	}
}
