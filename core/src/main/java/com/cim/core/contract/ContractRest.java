package com.cim.core.contract;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;
import com.cim.core.util.ServiceListResponse;

@RestController
@RequestMapping(AppConstants.API_PATH + "/contract")
public class ContractRest
{
	private static final Logger	log	= LoggerFactory.getLogger(ContractRest.class);

	private ContractService		contractService;

	@Autowired
	public ContractRest(@NotNull ContractService contractService)
	{
		this.contractService = contractService;
	}
	
	@GetMapping
	public ResponseEntity<ApiContractList> list(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "100") int size,
			@RequestParam(defaultValue = "id") String sort,
			@RequestParam(required = false) Long graveownerId)
	{
		log.debug("Fetching contracts for page={}, size={}, sort={}, graveownerId={}", 
				page, size, sort, graveownerId);
		
		ContractFilter filter = ContractAssembler.fromResource(graveownerId);
		log.debug("Using filter {}", filter);			
		
		ServiceListResponse<Contract> contracts = contractService.list(page, size, sort, filter);
		ApiContractList apiContracts = ContractAssembler.toResource(contracts);
		
		log.debug("Response {}", apiContracts);
		return ResponseEntity.ok(apiContracts);
	}
}
