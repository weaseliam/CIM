package com.cim.core.grave;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Grave
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;

	@NotNull
	private Long	graveyardId;

	private Long	contractId;

	private Long	oldId;
	private Integer	codZona;
	private String	sector;
	private String	rind;
	private String	pozitie;
	private Integer	nrLocuri;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getGraveyardId()
	{
		return graveyardId;
	}
	
	public void setGraveyardId(Long graveyardId)
	{
		this.graveyardId = graveyardId;
	}
	
	public Long getContractId()
	{
		return contractId;
	}
	
	public void setContractId(Long contractId)
	{
		this.contractId = contractId;
	}
	
	public Long getOldId()
	{
		return oldId;
	}
	
	public void setOldId(Long oldId)
	{
		this.oldId = oldId;
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
	
	public String getRind()
	{
		return rind;
	}
	
	public void setRind(String rind)
	{
		this.rind = rind;
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
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codZona == null) ? 0 : codZona.hashCode());
		result = prime * result + ((nrLocuri == null) ? 0 : nrLocuri.hashCode());
		result = prime * result + ((oldId == null) ? 0 : oldId.hashCode());
		result = prime * result + ((pozitie == null) ? 0 : pozitie.hashCode());
		result = prime * result + ((rind == null) ? 0 : rind.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grave other = (Grave) obj;
		if (codZona == null)
		{
			if (other.codZona != null)
				return false;
		}
		else if (!codZona.equals(other.codZona))
			return false;
		if (nrLocuri == null)
		{
			if (other.nrLocuri != null)
				return false;
		}
		else if (!nrLocuri.equals(other.nrLocuri))
			return false;
		if (oldId == null)
		{
			if (other.oldId != null)
				return false;
		}
		else if (!oldId.equals(other.oldId))
			return false;
		if (pozitie == null)
		{
			if (other.pozitie != null)
				return false;
		}
		else if (!pozitie.equals(other.pozitie))
			return false;
		if (rind == null)
		{
			if (other.rind != null)
				return false;
		}
		else if (!rind.equals(other.rind))
			return false;
		if (sector == null)
		{
			if (other.sector != null)
				return false;
		}
		else if (!sector.equals(other.sector))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Grave [id=" + id + ", graveyardId=" + graveyardId + ", contractId=" + contractId + ", oldId=" + oldId
				+ ", codZona=" + codZona + ", sector=" + sector + ", rind=" + rind + ", pozitie=" + pozitie
				+ ", nrLocuri=" + nrLocuri + "]";
	}
}
