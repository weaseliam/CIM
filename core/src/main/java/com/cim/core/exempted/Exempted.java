package com.cim.core.exempted;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Exempted
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	id;

	@NotNull
	private String	nume;

	public Long getId()
	{
		return id;
	}

	public void setId(long id)
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
		return "Exempted [id=" + id + ", nume=" + nume + "]";
	}
}
