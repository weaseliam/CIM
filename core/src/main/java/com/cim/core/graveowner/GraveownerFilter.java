package com.cim.core.graveowner;

public class GraveownerFilter
{
	private Long	id;
	private String	cnp;
	private String	nume;
	private String	prenume;
	private String	localitate;
	private String	judet;
	private String	adresa;

	public GraveownerFilter()
	{
	}

	public GraveownerFilter(Long id, String cnp, String nume, String prenume, String localitate, String judet,
			String adresa)
	{
		this.id = id;
		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
		this.localitate = localitate;
		this.judet = judet;
		this.adresa = adresa;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCnp()
	{
		return cnp;
	}

	public void setCnp(String cnp)
	{
		this.cnp = cnp;
	}

	public String getNume()
	{
		return nume;
	}

	public void setNume(String nume)
	{
		this.nume = nume;
	}

	public String getPrenume()
	{
		return prenume;
	}

	public void setPrenume(String prenume)
	{
		this.prenume = prenume;
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

	public String getAdresa()
	{
		return adresa;
	}

	public void setAdresa(String adresa)
	{
		this.adresa = adresa;
	}

	@Override
	public String toString()
	{
		return "GraveownerFilter [id=" + id + ", cnp=" + cnp + ", nume=" + nume + ", prenume=" + prenume
				+ ", localitate=" + localitate + ", judet=" + judet + ", adresa=" + adresa + "]";
	}
}
