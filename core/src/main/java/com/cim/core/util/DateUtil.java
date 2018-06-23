package com.cim.core.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtil
{
	public static Date toDate(LocalDateTime ldt)
	{
		if (ldt == null)
		{
			return null;
		}

		Instant instant = ldt.toInstant(ZoneOffset.UTC);
		Date date = Date.from(instant);
		
		return date;
	}

	public static LocalDateTime toLocalDateTime(Date d)
	{
		if (d == null)
		{
			return null;
		}

		Instant instant = Instant.ofEpochMilli(d.getTime());
		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

		return ldt;
	}
}
