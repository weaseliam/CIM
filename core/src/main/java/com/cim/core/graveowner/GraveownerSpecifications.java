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

	public static Specification<Graveowner> buildFilterSpecification(Long id, String cnp, String nume, String prenume,
			String localitate, String judet, String adresa)
	{
		Specification<Graveowner> specification = null;
		
		if (id != null && id > 0)
		{
			specification = GraveownerSpecifications.equal("id", id);
		}
		else
		{
			if (!StringUtils.isBlank(cnp))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("cnp", "%" + cnp.trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(nume))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("nume", "%" + nume.trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(prenume))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("prenume", "%" + prenume.trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(localitate))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("localitate", "%" + localitate.trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(judet))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("judet", "%" + judet.trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
			
			if (!StringUtils.isBlank(adresa))
			{
				Specification<Graveowner> spec = GraveownerSpecifications.like("adresa", "%" + adresa.trim() + "%");
				specification = specification != null ? specification.and(spec) : spec;
			}
		}
		
		return specification;
	}
}
