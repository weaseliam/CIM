package com.cim.core.grave;

import javax.validation.constraints.NotNull;

public class ApiGrave
{
	private Long			id;
	private Long			cimitirId;
	private Long			contractId;
	private Integer			codZona;
	private String			sector;
	private String			rand;
	private String			pozitie;
	private Integer			nrLocuri;

	public ApiGrave()
	{
	}

	public ApiGrave(@NotNull Grave grave)
	{
		id = grave.getId();
		cimitirId = grave.getGraveyardId();
		contractId = grave.getContractId();
		codZona = grave.getCodZona();
		sector = grave.getSector();
		rand = grave.getRind();
		pozitie = grave.getPozitie();
		nrLocuri = grave.getNrLocuri();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCimitirId()
	{
		return cimitirId;
	}

	public void setCimitirId(Long cimitirId)
	{
		this.cimitirId = cimitirId;
	}

	public Long getContractId()
	{
		return contractId;
	}

	public void setContractId(Long contractId)
	{
		this.contractId = contractId;
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

	@Override
	public String toString()
	{
		return "ApiGrave [id=" + id + ", cimitirId=" + cimitirId + ", contractId=" + contractId + ", codZona=" + codZona
				+ ", sector=" + sector + ", rand=" + rand + ", pozitie=" + pozitie + ", nrLocuri=" + nrLocuri + "]";
	}
}
