package com.cim.core.grave;

import java.util.Collections;
import java.util.List;

public class GraveFilter
{
	private List<Long> contractIds;
	private List<Long> ids;

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

	public List<Long> getIds()
	{
		if (ids == null)
		{
			ids = Collections.emptyList();
		}
		
		return ids;
	}

	public void setIds(List<Long> ids)
	{
		this.ids = ids;
	}

	@Override
	public String toString()
	{
		return "GraveFilter [contractIds=" + contractIds + ", ids=" + ids + "]";
	}

	public static class Builder
	{
		private List<Long> contractIds;
		private List<Long> ids;

		public Builder setContractIds(List<Long> contractIds)
		{
			this.contractIds = contractIds;
			return this;
		}

		public Builder setIds(List<Long> ids)
		{
			this.ids = ids;
			return this;
		}
		
		public GraveFilter build()
		{
			GraveFilter filter = new GraveFilter();
			filter.setContractIds(contractIds);
			filter.setIds(ids);

			return filter;
		}
	}
}
