package com.cim.core.graveowner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class GraveownerSpecifications
{
	public static Specification<Graveowner> equal(String name, Long value)
	{
		return new Specification<Graveowner>()
		{
			@Override
			public Predicate toPredicate(Root<Graveowner> root, CriteriaQuery<?> query, CriteriaBuilder cb)
			{
				return cb.equal(root.get(name), value);
			}
		};
	}
	
	public static Specification<Graveowner> like(String name, String value)
	{
		return new Specification<Graveowner>()
		{
			@Override
			public Predicate toPredicate(Root<Graveowner> root, CriteriaQuery<?> query, CriteriaBuilder cb)
			{
				return cb.like(cb.lower(root.get(name)), value.toLowerCase());
			}
		};
	}

	public static Specification<Graveowner> buildFilterSpec(GraveownerFilter filter)
	{
		Specification<Graveowner> specification = null;
		
		if (filter == null)
		{
			return specification;
		}
		
		if (filter.getId() != null && filter.getId() > 0)
		{
			specification = GraveownerSpecifications.equal("id", filter.getId());
		}
		else
		{
			if (!StringUtils.isBlank(filter.getCnp()))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("cnp", "%" + filter.getCnp().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getNume()))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("nume", "%" + filter.getNume().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getPrenume()))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("prenume", "%" + filter.getPrenume().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getLocalitate()))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("localitate", "%" + filter.getLocalitate().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getJudet()))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("judet", "%" + filter.getJudet().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(filter.getAdresa()))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("adresa", "%" + filter.getAdresa().trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
		}
		
		return specification;
	}
}
