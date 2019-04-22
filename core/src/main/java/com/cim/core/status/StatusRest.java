package com.cim.core.status;

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
import com.cim.core.contract.ContractFull;
import com.cim.core.util.ApiListResponse;
import com.cim.core.util.ServiceListResponse;

@RestController
@RequestMapping(AppConstants.API_PATH + "/status")
public class StatusRest
{
	private static final Logger	log	= LoggerFactory.getLogger(StatusRest.class);

	private StatusService		statusService;

	@Autowired
	public StatusRest(@NotNull StatusService statusService)
	{
		this.statusService = statusService;
	}

	@GetMapping(path = "/contract")
	public ResponseEntity<ApiListResponse<ApiContractStatus>> contractsStatus(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "0") int dte)
	{
		log.debug("Fetching contracts status for page={}, size={}, dte={}",
				page, size, dte);

		ServiceListResponse<ContractFull> contracts = statusService.listContractsFull(page, size, dte);
		ApiListResponse<ApiContractStatus> apiContractStatuses = StatusAssembler.toResource(contracts);

		log.debug("Response {}", apiContractStatuses);
		return ResponseEntity.ok(apiContractStatuses);
	}
}
