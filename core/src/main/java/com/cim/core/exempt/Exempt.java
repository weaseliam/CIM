package com.cim.core.exempt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Exempt
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;

	@NotNull
	private Integer	cod;

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

	public Integer getCod()
	{
		return cod;
	}

	public void setCod(Integer cod)
	{
		this.cod = cod;
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
		return "Exempt [id=" + id + ", cod=" + cod + ", nume=" + nume + "]";
	}
}
