package com.cim.core.app;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.cim.core.util.DateUtil;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Date>
{
	@Override
	public Date convertToDatabaseColumn(LocalDateTime ldt)
	{
		return DateUtil.toDate(ldt);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Date date)
	{
		return DateUtil.toLocalDateTime(date);
	}
}
