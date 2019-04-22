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
		else
		{
			if (filter.getDataExpGt() != null)
			{
				Specification<Contract> spec = SpecificationUtil.gt("dataExp", filter.getDataExpGt());
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (filter.getDataExpLt() != null)
			{
				Specification<Contract> spec = SpecificationUtil.lt("dataExp", filter.getDataExpLt());
				specification = specification != null ? specification.and(spec) : spec;
			}
		}

		return specification;
	}
}
