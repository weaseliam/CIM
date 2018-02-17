package com.cim.core.app;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class UiException
{
	private String							code;
	private String[]						params;
	private String							message;
	private String							timestamp;

	private static final String				TIMESTAMP_PATTERN	= "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat	TIMESTAMP_FORMAT	= new SimpleDateFormat(TIMESTAMP_PATTERN);

	public UiException()
	{
		updateTimestamp();
	}

	public UiException(@NotNull Throwable t)
	{
		updateTimestamp();

		if (t instanceof AppException)
		{
			AppException e = (AppException) t;

			setCode(e.getCode());
			setParams(e.getParams());
		}
		else
		{
			setCode(t.getClass().getName());
		}

		setMessage(t.getMessage());
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String[] getParams()
	{
		return params;
	}

	public void setParams(String[] params)
	{
		this.params = params;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	private void updateTimestamp()
	{
		setTimestamp(TIMESTAMP_FORMAT.format(new Date()));
	}

	@Override
	public String toString()
	{
		return "UiException [code=" + code + ", params=" + Arrays.toString(params) + ", message=" + message
				+ ", timestamp=" + timestamp + "]";
	}
}
