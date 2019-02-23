package com.cim.core.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

public class ApiException
{
	private String		code;
	private String[]	params;
	private String		message;
	private String		timestamp;

	public ApiException()
	{
		updateTimestamp();
	}

	public ApiException(@NotNull Throwable t)
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
		setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

	@Override
	public String toString()
	{
		return "UiException [code=" + code + ", params=" + Arrays.toString(params) + ", message=" + message
				+ ", timestamp=" + timestamp + "]";
	}
}
