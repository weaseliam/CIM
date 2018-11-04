package com.cim.core.graveowner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.cim.core.util.RestUtil;

@Service
public class GraveownerService
{
	private GraveownerRepository graveownerRepository;

	@Autowired
	public GraveownerService(@NotNull GraveownerRepository graveownerRepository)
	{
		this.graveownerRepository = graveownerRepository;
	}

	public List<Graveowner> save(List<Graveowner> graveowners)
	{
		List<Graveowner> savedGraveowners = new ArrayList<>();
		for (Graveowner graveowner : graveownerRepository.saveAll(graveowners))
		{
			savedGraveowners.add(graveowner);
		}

		return Collections.unmodifiableList(savedGraveowners);
	}

	public Graveowner findFirstByOldId(long id)
	{
		return graveownerRepository.findFirstByOldId(id);
	}

	public Page<Graveowner> list(int page, int size, String sort)
	{
		return list(page, size, sort, null);
	}
	
	public Page<Graveowner> list(int page, int size, String sort, GraveownerFilter filter)
	{
		Specification<Graveowner> spec = GraveownerSpecifications.buildFilterSpec(filter);
		
		PageRequest pageRequest = PageRequest.of(
				Math.max(page - 1, 0), 
				Math.max(size, 1), 
				RestUtil.toServiceSort(sort));
		
		Page<Graveowner> graveowners = graveownerRepository.findAll(spec, pageRequest);
		
		return graveowners;
	}
}
