package com.cim.core.grave;

public class GraveFilter
{
	private Long graveownerId;

	public GraveFilter()
	{
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

	public static class Builder
	{
		private Long graveownerId;

		public Builder setGraveownerId(Long graveownerId)
		{
			this.graveownerId = graveownerId;
			return this;
		}

		public GraveFilter build()
		{
			GraveFilter filter = new GraveFilter();
			filter.setGraveownerId(graveownerId);

			return filter;
		}
	}
}
