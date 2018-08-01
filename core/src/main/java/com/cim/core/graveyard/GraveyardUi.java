package com.cim.core.graveyard;

import javax.validation.constraints.NotNull;

public class GraveyardUi
{
	private Long	id;
	private String	nume;

	public GraveyardUi(@NotNull Graveyard graveyard)
	{
		this.id = graveyard.getId();
		this.nume = graveyard.getNume();
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
		return "GraveyardUi [id=" + id + ", nume=" + nume + "]";
	}
}
