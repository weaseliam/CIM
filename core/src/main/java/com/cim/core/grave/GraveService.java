package com.cim.core.grave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		for (Grave grave : graveRepository.save(graves))
		{
			savedGraves.add(grave);
		}

		return Collections.unmodifiableList(savedGraves);
	}
}
