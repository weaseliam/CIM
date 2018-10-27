package com.cim.core.graveyard;

import java.util.Map;

public class ApiGraveyardList
{
	private Map<Long, ApiGraveyard> graveyards;

	public ApiGraveyardList()
	{
	}

	public Map<Long, ApiGraveyard> getGraveyards()
	{
		return graveyards;
	}

	public void setGraveyards(Map<Long, ApiGraveyard> graveyards)
	{
		this.graveyards = graveyards;
	}

	@Override
	public String toString()
	{
		return "GraveyardListUi [graveyards=" + graveyards + "]";
	}
}
