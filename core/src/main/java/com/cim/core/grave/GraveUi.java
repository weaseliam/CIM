package com.cim.core.grave;

import javax.validation.constraints.NotNull;

public class GraveUi
{
	private Long	id;
	private Integer	codZona;
	private String	sector;
	private String	rand;
	private String	pozitie;
	private Integer	nrLocuri;
	private Integer	ani;

	public GraveUi()
	{
	}

	public GraveUi(@NotNull Grave grave)
	{
		id = grave.getId();
		codZona = grave.getCodZona();
		sector = grave.getSector();
		rand = grave.getRind();
		pozitie = grave.getPozitie();
		nrLocuri = grave.getNrLocuri();
		ani = grave.getAni();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Integer getCodZona()
	{
		return codZona;
	}

	public void setCodZona(Integer codZona)
	{
		this.codZona = codZona;
	}

	public String getSector()
	{
		return sector;
	}

	public void setSector(String sector)
	{
		this.sector = sector;
	}

	public String getRand()
	{
		return rand;
	}

	public void setRand(String rand)
	{
		this.rand = rand;
	}

	public String getPozitie()
	{
		return pozitie;
	}

	public void setPozitie(String pozitie)
	{
		this.pozitie = pozitie;
	}

	public Integer getNrLocuri()
	{
		return nrLocuri;
	}

	public void setNrLocuri(Integer nrLocuri)
	{
		this.nrLocuri = nrLocuri;
	}

	public Integer getAni()
	{
		return ani;
	}

	public void setAni(Integer ani)
	{
		this.ani = ani;
	}

	@Override
	public String toString()
	{
		return "GraveUi [id=" + id + ", codZona=" + codZona + ", sector=" + sector + ", rand=" + rand + ", pozitie="
				+ pozitie + ", nrLocuri=" + nrLocuri + ", ani=" + ani + "]";
	}
}
