package com.cim.core.graveowner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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
		PageRequest pageRequest = PageRequest.of(
				Math.max(page - 1, 0), 
				Math.max(size, 1), 
				computeSort(sort));
		Page<Graveowner> graveowners = graveownerRepository.findAll(pageRequest);
		
		return graveowners;
	}

	private Sort computeSort(String property)
	{
		boolean isDescending = property != null && property.startsWith("-");
		
		List<Order> order = new ArrayList<>();
		order.add(new Order(
				isDescending ? Direction.DESC : Direction.ASC, 
				isDescending ? property.substring(1) : property));
		
		if (!property.equalsIgnoreCase("id"))
		{
			order.add(new Order(Direction.ASC, "id"));
		}
		
		return Sort.by(order);
	}
}
