package com.cim.core.app;

import java.util.Arrays;

public class AppException extends RuntimeException
{
	private String		code;
	private String[]	params;
	private Integer		status;

	public AppException()
	{
		super();
	}

	public AppException(String code)
	{
		super(code);
		this.code = code;
	}
	
	public AppException(String code, Integer status)
	{
		this(code);
		this.status = status;
	}
	
	public AppException(String code, Throwable t)
	{
		super(code, t);
		this.code = code;
	}
	
	public AppException(String code, Throwable t, Integer status)
	{
		this(code, t);
		this.status = status;
	}
	
	public AppException(String code, String[] params)
	{
		this(code);
		this.params = params;
	}
	
	public AppException(String code, String[] params, Integer status)
	{
		this(code, params);
		this.status = status;
	}

	public AppException(String code, String[] params, Throwable t)
	{
		this(code, t);
		this.params = params;
	}
	
	public AppException(String code, String[] params, Throwable t, Integer status)
	{
		this(code, params, t);
		this.status = status;
	}

	public AppException(String code, String[] params, String message)
	{
		super(message);
		this.code = code;
		this.params = params;
	}
	
	public AppException(String code, String[] params, String message, Integer status)
	{
		this(code, params, message);
		this.status = status;
	}

	public AppException(String code, String[] params, String message, Throwable t)
	{
		super(message, t);
		this.code = code;
		this.params = params;
	}
	
	public AppException(String code, String[] params, String message, Throwable t, Integer status)
	{
		this(code, params, message, t);
		this.status = status;
	}

	public AppException(String code, String message)
	{
		this(code, null, message);
	}
	
	public AppException(String code, String message, Integer status)
	{
		this(code, message);
		this.status = status;
	}

	public AppException(String code, String message, Throwable t)
	{
		this(code, null, message, t);
	}
	
	public AppException(String code, String message, Throwable t, Integer status)
	{
		this(code, message, t);
		this.status = status;
	}

	public String getCode()
	{
		return code;
	}

	public String[] getParams()
	{
		return params;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "AppException [code=" + code + ", params=" + Arrays.toString(params) + ", status=" + status
				+ "]";
	}
}
