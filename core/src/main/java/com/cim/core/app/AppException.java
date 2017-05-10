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
		super(code);
		this.code = code;
	}
	
	public AppException(String code, Throwable t)
	{
		super(code, t);
		this.code = code;
	}
	
	public AppException(String code, String[] params)
	{
		super(code);
		this.code = code;
		this.params = params;
	}

	public AppException(String code, String[] params, Throwable t)
	{
		super(code, t);
		this.code = code;
		this.params = params;
	}

	public AppException(String code, String[] params, String message)
	{
		super(message);
		this.code = code;
		this.params = params;
	}

	public AppException(String code, String[] params, String message, Throwable t)
	{
		super(message, t);
		this.code = code;
		this.params = params;
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

	public String[] getParams()
	{
		return params;
	}

	@Override
	public String toString()
	{
		return "AppException [code=" + code + ", params=" + Arrays.toString(params) + ", message=" + getMessage() + "]";
	}
}
