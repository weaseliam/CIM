package com.cim.core.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationUtil
{
	public static <T> Specification<T> equal(String name, Long value)
	{
		return new Specification<T>()
		{
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb)
			{
				return cb.equal(root.get(name), value);
			}
		};
	}
	
	public static <T> Specification<T> like(String name, String value)
	{
		return new Specification<T>()
		{
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb)
			{
				return cb.like(cb.lower(root.get(name)), value.toLowerCase());
			}
		};
	}
}
