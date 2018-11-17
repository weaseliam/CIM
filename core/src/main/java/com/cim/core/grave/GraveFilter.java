package com.cim.core.grave;

import java.util.Collections;
import java.util.List;

public class GraveFilter
{
	private List<Long> contractIds;

	public GraveFilter()
	{
	}

	public List<Long> getContractIds()
	{
		if (contractIds == null)
		{
			return Collections.emptyList();
		}

		return contractIds;
	}

	public void setContractIds(List<Long> contractIds)
	{
		this.contractIds = contractIds;
	}

	@Override
	public String toString()
	{
		return "GraveFilter [contractIds=" + contractIds + "]";
	}

	public static class Builder
	{
		private List<Long> contractIds;

		public Builder setContractIds(List<Long> contractIds)
		{
			this.contractIds = contractIds;
			return this;
		}

		public GraveFilter build()
		{
			GraveFilter filter = new GraveFilter();
			filter.setContractIds(contractIds);

			return filter;
		}
	}
}
