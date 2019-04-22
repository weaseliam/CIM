package com.cim.core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class RestUtil
{
	private RestUtil()
	{
	}
	
	public static Sort toServiceSort(String property)
	{
		List<Order> order = new ArrayList<>();
		
		if (!StringUtils.isBlank(property))
		{
			boolean isDescending = property.startsWith("-");
			order.add(new Order(
					isDescending ? Direction.DESC : Direction.ASC, 
					isDescending ? property.substring(1) : property));
		}
		
		if (!"id".equalsIgnoreCase(property))
		{
			order.add(new Order(Direction.ASC, "id"));
		}
		
		return Sort.by(order);
	}
}
