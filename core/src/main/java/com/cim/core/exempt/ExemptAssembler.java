package com.cim.core.exempt;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

public class ExemptAssembler
{
	public static ExemptListUi toUi(@NotNull List<Exempt> exempts)
	{
		ExemptListUi response = new ExemptListUi();
		Map<Long, ExemptUi> uiExempts = exempts.stream()
				.map(exempt -> new ExemptUi(exempt))
				.collect(Collectors.toMap(ExemptUi::getId, Function.identity()));
		response.setExempts(uiExempts);
		
		return response;
	}
}
