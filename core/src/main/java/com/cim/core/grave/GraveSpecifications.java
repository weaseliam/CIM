package com.cim.core.grave;

import org.springframework.data.jpa.domain.Specification;

import com.cim.core.util.SpecificationUtil;

public class GraveSpecifications
{
	public static Specification<Grave> buildFilterSpec(GraveFilter filter)
	{
		Specification<Grave> specification = null;

		if (filter == null)
		{
			return specification;
		}

		if (!filter.getIds().isEmpty())
		{
			specification = SpecificationUtil.in("id", filter.getIds());
		}
		
		if (!filter.getContractIds().isEmpty())
		{
			Specification<Grave> spec = SpecificationUtil.in("contractId", filter.getContractIds());
			specification = specification != null ? specification.and(spec) : spec;
		}

		return specification;
	}
}
