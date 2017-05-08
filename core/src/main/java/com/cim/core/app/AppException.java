package com.cim.core.app;

import java.util.Arrays;

public class AppException extends RuntimeException
{
	private String code;
	private String[] params;

	public AppException()
	{
		super();
	}

	public AppException(String code)
	{
		super();
		setCode(code);
	}
	
	public AppException(String code, Throwable t)
	{
		super(t);
		setCode(code);
	}
	
	public AppException(String code, String[] params)
	{
		super();
		setCode(code);
		setParams(params);
	}

	public AppException(String code, String[] params, Throwable t)
	{
		super(t);
		setCode(code);
		setParams(params);
	}

	public AppException(String code, String[] params, String message)
	{
		super(message);
		setCode(code);
		setParams(params);
	}

	public AppException(String code, String[] params, String message, Throwable t)
	{
		super(message, t);
		setCode(code);
		setParams(params);
	}

	public AppException(String code, String message)
	{
		this(code, null, message);
	}

	public AppException(String code, String message, Throwable t)
	{
		this(code, null, message, t);
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

	@Override
	public String toString()
	{
		return "AppException [code=" + code + ", params=" + Arrays.toString(params) + ", message=" + getMessage() + "]";
	}
}
