package com.cim.core.contract;

import java.time.LocalDateTime;

public class ContractFilter
{
	private Long			graveownerId;
	private LocalDateTime	dataExpGt;
	private LocalDateTime	dataExpLt;

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

	public LocalDateTime getDataExpGt()
	{
		return dataExpGt;
	}

	public void setDataExpGt(LocalDateTime dataExpGt)
	{
		this.dataExpGt = dataExpGt;
	}

	public LocalDateTime getDataExpLt()
	{
		return dataExpLt;
	}

	public void setDataExpLt(LocalDateTime dataExpLt)
	{
		this.dataExpLt = dataExpLt;
	}

	@Override
	public String toString()
	{
		return "ContractFilter [graveownerId=" + graveownerId + ", dataExpGt=" + dataExpGt + ", dataExpLt=" + dataExpLt
				+ "]";
	}

	public static class Builder
	{
		private Long			graveownerId;
		private LocalDateTime	dataExpGt;
		private LocalDateTime	dataExpLt;

		public Builder setGraveownerId(Long graveownerId)
		{
			this.graveownerId = graveownerId;
			return this;
		}

		public Builder setDataExpGt(LocalDateTime dataExpGt)
		{
			this.dataExpGt = dataExpGt;
			return this;
		}

		public Builder setDataExpLt(LocalDateTime dataExpLt)
		{
			this.dataExpLt = dataExpLt;
			return this;
		}

		public ContractFilter build()
		{
			ContractFilter filter = new ContractFilter();
			filter.setGraveownerId(graveownerId);
			filter.setDataExpGt(dataExpGt);
			filter.setDataExpLt(dataExpLt);

			return filter;
		}
	}
}
