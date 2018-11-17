package com.cim.core.grave;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

public class GraveAssembler
{
	private GraveAssembler()
	{
		// private constructor
	}
	
	public static ApiGraveList toResource(@NotNull Page<Grave> page, String sort)
	{
		ApiGraveList response = new ApiGraveList();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		
		List<ApiGrave> graves = page.getContent().stream()
				.map(grave -> new ApiGrave(grave))
				.collect(Collectors.toList());
		response.setGraves(graves);
		
		return response;
	}

	public static GraveFilter fromResource(List<Long> contractIds)
	{
		if (contractIds == null)
		{
			return null;
		}

		GraveFilter filter = new GraveFilter.Builder()
				.setContractIds(contractIds)
				.build();

		return filter;
	}
}
