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
		
		if (filter.getGraveownerId() != null && filter.getGraveownerId() > 0)
		{
			specification = SpecificationUtil.equal("graveownerId", filter.getGraveownerId());
		}
		
		return specification;
	}
}
