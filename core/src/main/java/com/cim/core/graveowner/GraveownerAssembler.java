package com.cim.core.graveowner;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public class GraveownerAssembler
{
	public static GraveownerListUi toResource(Page<Graveowner> page, String sort)
	{
		GraveownerListUi response = new GraveownerListUi();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		
		List<GraveownerUi> graveowners = page.getContent().stream()
				.map(graveowner -> new GraveownerUi(graveowner))
				.collect(Collectors.toList());
		response.setGraveowners(graveowners);
		
		return response;
	}
}
