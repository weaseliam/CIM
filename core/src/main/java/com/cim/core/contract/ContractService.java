package com.cim.core.contract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cim.core.grave.Grave;
import com.cim.core.grave.GraveFilter;
import com.cim.core.grave.GraveService;
import com.cim.core.graveowner.Graveowner;
import com.cim.core.graveowner.GraveownerFilter;
import com.cim.core.graveowner.GraveownerService;
import com.cim.core.util.RestUtil;
import com.cim.core.util.ServiceListResponse;

@Service
public class ContractService
{
	private ContractRepository	contractRepository;
	private GraveownerService	graveownerService;
	private GraveService		graveService;

	@Autowired
	public ContractService(@NotNull ContractRepository contractRepository, @NotNull GraveownerService graveownerService,
			@NotNull GraveService graveService)
	{
		this.contractRepository = contractRepository;
		this.graveownerService = graveownerService;
		this.graveService = graveService;
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
	
	public ServiceListResponse<Contract> list(int page, int size, String sort, ContractFilter filter)
	{
		Specification<Contract> spec = ContractSpecifications.buildFilterSpec(filter);
		
		PageRequest pageRequest = PageRequest.of(
				Math.max(page - 1, 0), 
				Math.max(size, 1), 
				RestUtil.toServiceSort(sort));
		
		Page<Contract> contracts = contractRepository.findAll(spec, pageRequest);
		ServiceListResponse<Contract> response = ContractAssembler.toServiceListResponse(contracts, sort);
		
		return response;
	}
	
	public ServiceListResponse<ContractFull> listFull(int page, int size, String sort, ContractFilter filter)
	{
		Set<Long> graveownerIds = new HashSet<>();
		Set<Long> graveIds = new HashSet<>();
		
		ServiceListResponse<Contract> contracts = list(page, size, sort, filter);
		for (Contract contract : contracts.getResults())
		{
			graveownerIds.add(contract.getGraveownerId());
			graveIds.add(contract.getGraveId());
		}
		
		GraveownerFilter oFilter = new GraveownerFilter.Builder()
				.setIds(graveownerIds.stream().collect(Collectors.toList()))
				.build();
		ServiceListResponse<Graveowner> graveowners = graveownerService.list(1, size, null, oFilter);
		Map<Long, Graveowner> graveownerIdToGraveowner = graveowners.getResults().stream()
				.collect(Collectors.toMap(Graveowner::getId, Function.identity()));
		
		GraveFilter gFilter = new GraveFilter.Builder()
				.setIds(graveIds.stream().collect(Collectors.toList()))
				.build();
		ServiceListResponse<Grave> graves = graveService.list(1, size, null, gFilter);
		Map<Long, Grave> graveIdToGrave = graves.getResults().stream()
				.collect(Collectors.toMap(Grave::getId, Function.identity()));
	
		List<ContractFull> fullContracts = contracts.getResults().stream()
				.map(contract -> new ContractFull(
						contract, 
						graveownerIdToGraveowner.get(contract.getGraveownerId()),
						graveIdToGrave.get(contract.getGraveId())))
				.collect(Collectors.toList());
		
		ServiceListResponse<ContractFull> response = new ServiceListResponse<>();
		response.setPage(contracts.getPage());
		response.setSize(contracts.getSize());
		response.setSort(sort);
		response.setTotalPages(contracts.getTotalPages());
		response.setTotalResults(contracts.getTotalResults());
		response.setResults(fullContracts);
		
		return response;
	}
}
