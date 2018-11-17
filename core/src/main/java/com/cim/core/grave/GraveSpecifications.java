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
		
		if (!filter.getContractIds().isEmpty())
		{
			for (Long contractId : filter.getContractIds())
			{
				Specification<Grave> subSpec = SpecificationUtil.equal("contractId", contractId);
				
				specification = specification == null 
						? subSpec 
						: specification.or(subSpec);
			}
		}
		
		return specification;
	}
}
