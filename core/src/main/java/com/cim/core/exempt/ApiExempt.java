package com.cim.core.exempt;

import javax.validation.constraints.NotNull;

public class ApiExempt
{
	private Long	id;
	private String	nume;

	public ApiExempt(@NotNull Exempt exempt)
	{
		this.id = exempt.getId();
		this.nume = exempt.getNume();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNume()
	{
		return nume;
	}

	public void setNume(String nume)
	{
		this.nume = nume;
	}

	@Override
	public String toString()
	{
		return "ExemptUi [id=" + id + ", nume=" + nume + "]";
	}
}
