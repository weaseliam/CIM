package com.cim.core.graveowner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

	public Graveowner findFirstByMarca(long marca)
	{
		return graveownerRepository.findFirstByMarca(marca);
	}

	public Page<Graveowner> list(int page, int size, String sort)
	{
		return list(page, size, sort, null);
	}
	
	public Page<Graveowner> list(int page, int size, String sort, GraveownerFilter filter)
	{
		Specification<Graveowner> specification = GraveownerSpecifications.buildFilterSpecification(filter);
		
		PageRequest pageRequest = PageRequest.of(
				Math.max(page - 1, 0), 
				Math.max(size, 1), 
				computeSort(sort));
		
		Page<Graveowner> graveowners = graveownerRepository.findAll(specification, pageRequest);
		
		return graveowners;
	}
	
	private Sort computeSort(String property)
	{
		List<Order> order = new ArrayList<>();
		
		if (!StringUtils.isBlank(property))
		{
			boolean isDescending = property.startsWith("-");
			order.add(new Order(
					isDescending ? Direction.DESC : Direction.ASC, 
					isDescending ? property.substring(1) : property));
		}
		
		if (!"id".equalsIgnoreCase(property))
		{
			order.add(new Order(Direction.ASC, "id"));
		}
		
		return Sort.by(order);
	}
}
