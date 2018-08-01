package com.cim.core.graveyard;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

public class GraveyardAssembler
{
	public static GraveyardListUi toResource(@NotNull List<Graveyard> graveyards)
	{
		GraveyardListUi response = new GraveyardListUi();
		Map<Long, GraveyardUi> uiGraveyards = graveyards.stream()
				.map(graveyard -> new GraveyardUi(graveyard))
				.collect(Collectors.toMap(GraveyardUi::getId, Function.identity()));
		response.setGraveyards(uiGraveyards);
		
		return response;
	}
}
