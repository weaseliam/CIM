package com.cim.core.contract;

public class ContractFilter
{
	private Long graveownerId;

	public ContractFilter()
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

		public ContractFilter build()
		{
			ContractFilter filter = new ContractFilter();
			filter.setGraveownerId(graveownerId);

			return filter;
		}
	}
}
