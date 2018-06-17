package com.cim.core.grave;

public class GraveFilter
{
	private Long graveownerId;
	
	public GraveFilter()
	{
	}
	
	public GraveFilter(Long graveownerId)
	{
		this.setGraveownerId(graveownerId);
	}

	public Long getGraveownerId()
	{
		return graveownerId;
	}

	public void setGraveownerId(Long graveownerId)
	{
		this.graveownerId = graveownerId;
	}

	@Override
	public String toString()
	{
		return "GraveFilter [graveownerId=" + graveownerId + "]";
	}
}
