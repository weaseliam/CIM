package com.cim.core.grave;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

import com.cim.core.util.ServiceListResponse;

public class GraveAssembler
{
	private GraveAssembler()
	{
		// private constructor
	}
	
	public static ApiGraveList toResource(@NotNull ServiceListResponse<Grave> page)
	{
		ApiGraveList response = new ApiGraveList();
		response.setPage(page.getPage());
		response.setSize(page.getSize());
		response.setSort(page.getSort());
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalResults());
		
		List<ApiGrave> graves = page.getResponse().stream()
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

	public static ServiceListResponse<Grave> toServiceListResponse(Page<Grave> page, String sort)
	{
		ServiceListResponse<Grave> response = new ServiceListResponse<Grave>();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		response.setResponse(page.getContent());
		
		return response;
	}
}
