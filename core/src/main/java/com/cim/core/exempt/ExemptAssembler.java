package com.cim.core.exempt;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

public class ExemptAssembler
{
	private ExemptAssembler()
	{
		// private constructor
	}
	
	public static ApiExemptList toResource(@NotNull List<Exempt> exempts)
	{
		ApiExemptList response = new ApiExemptList();
		Map<Long, ApiExempt> uiExempts = exempts.stream()
				.map(exempt -> new ApiExempt(exempt))
				.collect(Collectors.toMap(ApiExempt::getId, Function.identity()));
		response.setExempts(uiExempts);
		
		return response;
	}
}
