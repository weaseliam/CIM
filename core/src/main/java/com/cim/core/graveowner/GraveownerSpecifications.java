package com.cim.core.graveowner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.cim.core.util.SpecificationUtil;

public class GraveownerSpecifications
{
	public static Specification<Graveowner> buildFilterSpec(GraveownerFilter filter)
	{
		Specification<Graveowner> specification = null;
		
		if (filter == null)
		{
			return specification;
		}
		
		if (filter.getId() != null && filter.getId() > 0)
		{
			specification = SpecificationUtil.equal("id", filter.getId());
		}
		else
		{
			if (!StringUtils.isBlank(filter.getCnp()))
			{
				Specification<Graveowner> spec = SpecificationUtil.like("cnp", "%" + filter.getCnp().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getNume()))
			{
				Specification<Graveowner> spec = SpecificationUtil.like("nume", "%" + filter.getNume().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getPrenume()))
			{
				Specification<Graveowner> spec = SpecificationUtil.like("prenume", "%" + filter.getPrenume().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getLocalitate()))
			{
				Specification<Graveowner> spec = SpecificationUtil.like("localitate", "%" + filter.getLocalitate().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getJudet()))
			{
				Specification<Graveowner> spec = SpecificationUtil.like("judet", "%" + filter.getJudet().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getAdresa()))
			{
				Specification<Graveowner> spec = SpecificationUtil.like("adresa", "%" + filter.getAdresa().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
		}
		
		return specification;
	}
}
