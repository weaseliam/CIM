package com.cim.core.exempt;

import java.util.Map;

public class ApiExemptList
{
	private Map<Long, ApiExempt> exempts;

	public ApiExemptList()
	{
	}

	public Map<Long, ApiExempt> getExempts()
	{
		return exempts;
	}

	public void setExempts(Map<Long, ApiExempt> exempts)
	{
		this.exempts = exempts;
	}
	
	@Override
	public String toString()
	{
		return "ExemptListUi [exempts=" + exempts + "]";
	}
}
