package com.cim.core.contract;

import org.springframework.data.jpa.domain.Specification;

import com.cim.core.util.SpecificationUtil;

public class ContractSpecifications
{
	public static Specification<Contract> buildFilterSpec(ContractFilter filter)
	{
		Specification<Contract> specification = null;

		if (filter == null)
		{
			return specification;
		}

		if (filter.getGraveownerId() != null && filter.getGraveownerId() > 0)
		{
			specification = SpecificationUtil.equal("graveownerId", filter.getGraveownerId());
		}

		return specification;
	}
}
