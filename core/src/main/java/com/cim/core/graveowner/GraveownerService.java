package com.cim.core.graveowner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
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
		for (Graveowner graveowner : graveownerRepository.save(graveowners))
		{
			savedGraveowners.add(graveowner);
		}
		
		return Collections.unmodifiableList(savedGraveowners);
	}

	public Graveowner findFirstByMarca(long marca)
	{
		return graveownerRepository.findFirstByMarca(marca);
	}
}
