package com.cim.core.graveyard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraveyardService
{
	private GraveyardRepository graveyardRepository;

	@Autowired
	public GraveyardService(@NotNull GraveyardRepository graveyardRepository)
	{
		this.graveyardRepository = graveyardRepository;
	}

	public List<Graveyard> save(List<Graveyard> graveyards)
	{
		List<Graveyard> savedGraveowners = new ArrayList<>();
		for (Graveyard graveyard : graveyardRepository.save(graveyards))
		{
			savedGraveowners.add(graveyard);
		}

		return Collections.unmodifiableList(savedGraveowners);
	}

	public Graveyard findFirstByNume(String nume)
	{
		return graveyardRepository.findFirstByNume(nume);
	}
}
