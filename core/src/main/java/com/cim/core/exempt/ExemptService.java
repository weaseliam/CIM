package com.cim.core.exempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExemptService
{
	private ExemptRepository exemptRepository;

	@Autowired
	public ExemptService(@NotNull ExemptRepository exemptRepository)
	{
		this.exemptRepository = exemptRepository;
	}

	public List<Exempt> save(List<Exempt> exempts)
	{
		List<Exempt> savedExempts = new ArrayList<>();
		for (Exempt exempt : exemptRepository.save(exempts))
		{
			savedExempts.add(exempt);
		}

		return Collections.unmodifiableList(savedExempts);
	}

	public Exempt findFirstByCod(Integer cod)
	{
		return exemptRepository.findFirstByCod(cod);
	}
}
