package com.cim.core.graveyard;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

public class GraveyardAssembler
{
	private GraveyardAssembler()
	{
		// private constructor
	}
	
	public static ApiGraveyardList toResource(@NotNull List<Graveyard> graveyards)
	{
		ApiGraveyardList response = new ApiGraveyardList();
		Map<Long, ApiGraveyard> uiGraveyards = graveyards.stream()
				.map(graveyard -> new ApiGraveyard(graveyard))
				.collect(Collectors.toMap(ApiGraveyard::getId, Function.identity()));
		response.setGraveyards(uiGraveyards);
		
		return response;
	}
}
