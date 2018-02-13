package com.cim.core.app;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDateTime, Date>
{
	@Override
	public Date convertToDatabaseColumn(LocalDateTime ldt)
	{
		if (ldt == null)
		{
			return null;
		}

		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		Date date = Date.from(instant);

		return date;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Date date)
	{
		if (date == null)
		{
			return null;
		}

		Instant instant = Instant.ofEpochMilli(date.getTime());
		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

		return ldt;
	}
}
