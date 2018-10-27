package com.cim.core.graveowner;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

public class GraveownerAssembler
{
	public GraveownerAssembler()
	{
		// private constructor
	}
	
	public static ApiGraveownerList toResource(@NotNull Page<Graveowner> page, String sort, GraveownerFilter filter)
	{
		ApiGraveownerList response = new ApiGraveownerList();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		response.setFilter(filter != null ? new ApiGraveownerFilter(filter) : null);
		
		List<ApiGraveowner> graveowners = page.getContent().stream()
				.map(graveowner -> new ApiGraveowner(graveowner))
				.collect(Collectors.toList());
		response.setGraveowners(graveowners);
		
		return response;
	}
}
