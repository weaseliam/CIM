package com.cim.core.exempt;

import java.util.Map;

public class ExemptListUi
{
	private Map<Long, ExemptUi> exempts;

	public ExemptListUi()
	{
	}

	public Map<Long, ExemptUi> getExempts()
	{
		return exempts;
	}

	public void setExempts(Map<Long, ExemptUi> exempts)
	{
		this.exempts = exempts;
	}
	
	@Override
	public String toString()
	{
		return "ExemptListUi [exempts=" + exempts + "]";
	}
}
