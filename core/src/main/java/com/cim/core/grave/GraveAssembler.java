package com.cim.core.grave;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

public class GraveAssembler
{
	public static GraveListUi toResource(@NotNull Page<Grave> page, String sort)
	{
		GraveListUi response = new GraveListUi();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		
		List<GraveUi> graves = page.getContent().stream()
				.map(grave -> new GraveUi(grave))
				.collect(Collectors.toList());
		response.setGraves(graves);
		
		return response;
	}
}
