package com.cim.core.graveyard;

import java.util.Map;

public class GraveyardListUi
{
	private Map<Long, GraveyardUi> graveyards;

	public GraveyardListUi()
	{
	}

	public Map<Long, GraveyardUi> getGraveyards()
	{
		return graveyards;
	}

	public void setGraveyards(Map<Long, GraveyardUi> graveyards)
	{
		this.graveyards = graveyards;
	}

	@Override
	public String toString()
	{
		return "GraveyardListUi [graveyards=" + graveyards + "]";
	}
}
