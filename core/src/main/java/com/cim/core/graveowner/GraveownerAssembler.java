package com.cim.core.graveowner;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

import com.cim.core.util.ServiceListResponse;

public class GraveownerAssembler
{
	public GraveownerAssembler()
	{
		// private constructor
	}
	
	public static ApiGraveownerList toResource(@NotNull ServiceListResponse<Graveowner> page, GraveownerFilter filter)
	{
		ApiGraveownerList response = new ApiGraveownerList();
		response.setPage(page.getPage());
		response.setSize(page.getSize());
		response.setSort(page.getSort());
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalResults());
		response.setFilter(filter != null ? new ApiGraveownerFilter(filter) : null);
		
		List<ApiGraveowner> graveowners = page.getResponse().stream()
				.map(graveowner -> new ApiGraveowner(graveowner))
				.collect(Collectors.toList());
		response.setGraveowners(graveowners);
		
		return response;
	}

	public static GraveownerFilter fromResource(Long id, String cnp, String nume, String prenume, String localitate,
			String judet, String adresa)
	{
		if (id == null && cnp == null && nume == null && prenume == null && 
			localitate == null && judet == null && adresa == null)
		{
			return null;
		}

		GraveownerFilter filter = new GraveownerFilter.Builder()
				.setId(id).setCnp(cnp).setNume(nume).setPrenume(prenume)
				.setLocalitate(localitate).setJudet(judet).setAdresa(adresa)
				.build();

		return filter;
	}

	public static ServiceListResponse<Graveowner> toServiceListResponse(Page<Graveowner> page, String sort)
	{
		ServiceListResponse<Graveowner> response = new ServiceListResponse<Graveowner>();
		response.setPage(page.getNumber() + 1);
		response.setSize(page.getNumberOfElements());
		response.setSort(sort);
		response.setTotalPages(page.getTotalPages());
		response.setTotalResults(page.getTotalElements());
		response.setResponse(page.getContent());
		
		return response;
	}
}
