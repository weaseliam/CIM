package com.cim.core.graveowner;

import javax.validation.constraints.NotNull;

public class GraveownerUi
{
	private Long	id;
	private String	cnp;
	private String	nume;
	private String	prenume;
	private String	localitate;
	private String	judet;
	private String	str;
	private String	nr;
	private String	bl;
	private String	sc;
	private String	et;
	private String	ap;

	public GraveownerUi()
	{
	}
	
	public GraveownerUi(@NotNull Graveowner graveowner)
	{
		id = graveowner.getId();
		cnp = graveowner.getCnp();
		nume = graveowner.getNume();
		prenume = graveowner.getPrenume();
		localitate = graveowner.getLocalitate();
		judet = graveowner.getJudet();
		str = graveowner.getStr();
		nr = graveowner.getNr();
		bl = graveowner.getBl();
		sc = graveowner.getSc();
		et = graveowner.getEt();
		ap = graveowner.getAp();
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

	public String getBl()
	{
		return bl;
	}

	public void setBl(String bl)
	{
		this.bl = bl;
	}

	public String getSc()
	{
		return sc;
	}

	public void setSc(String sc)
	{
		this.sc = sc;
	}

	public String getEt()
	{
		return et;
	}

	public void setEt(String et)
	{
		this.et = et;
	}

	public String getAp()
	{
		return ap;
	}

	public void setAp(String ap)
	{
		this.ap = ap;
	}

	@Override
	public String toString()
	{
		return "GraveownerUi [id=" + id + ", cnp=" + cnp + ", nume=" + nume + ", prenume=" + prenume + ", localitate="
				+ localitate + ", judet=" + judet + ", str=" + str + ", nr=" + nr + ", bl=" + bl + ", sc=" + sc
				+ ", et=" + et + ", ap=" + ap + "]";
	}
}
