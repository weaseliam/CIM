package com.cim.core.graveyard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Graveyard
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;

	@NotNull
	private String	nume;

	@NotNull
	private String	localitate;

	@NotNull
	private String	judet;

	@NotNull
	private String	tara;

	@NotNull
	private String	str;

	@NotNull
	private String	nr;

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

	public String getLocalitate()
	{
		return localitate;
	}

	public void setLocalitate(String localitate)
	{
		this.localitate = localitate;
	}

	public String getJudet()
	{
		return judet;
	}

	public void setJudet(String judet)
	{
		this.judet = judet;
	}

	public String getTara()
	{
		return tara;
	}

	public void setTara(String tara)
	{
		this.tara = tara;
	}

	public String getStr()
	{
		return str;
	}

	public void setStr(String str)
	{
		this.str = str;
	}

	public String getNr()
	{
		return nr;
	}

	public void setNr(String nr)
	{
		this.nr = nr;
	}

	@Override
	public String toString()
	{
		return "Graveyard [id=" + id + ", nume=" + nume + ", localitate=" + localitate + ", judet=" + judet + ", tara="
				+ tara + ", str=" + str + ", nr=" + nr + "]";
	}
}
