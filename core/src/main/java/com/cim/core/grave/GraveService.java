package com.cim.core.grave;

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
public class GraveService
{
	private GraveRepository graveRepository;

	@Autowired
	public GraveService(@NotNull GraveRepository graveRepository)
	{
		this.graveRepository = graveRepository;
	}

	public List<Grave> save(List<Grave> graves)
	{
		List<Grave> savedGraves = new ArrayList<>();
		for (Grave grave : graveRepository.saveAll(graves))
		{
			savedGraves.add(grave);
		}

		return Collections.unmodifiableList(savedGraves);
	}

	public Page<Grave> list(int page, int size, String sort, GraveFilter filter)
	{
		Specification<Grave> spec = GraveSpecifications.buildFilterSpec(filter);
		
		PageRequest pageRequest = PageRequest.of(
				Math.max(page - 1, 0), 
				Math.max(size, 1), 
				RestUtil.toServiceSort(sort));
		
		Page<Grave> graves = graveRepository.findAll(spec, pageRequest);
		
		return graves;
	}
}
