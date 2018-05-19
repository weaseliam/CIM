package com.cim.core.grave;

import java.math.BigDecimal;
import java.util.Date;

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
	private Long		id;

	@NotNull
	private Long		graveownerId;

	@NotNull
	private Long		graveyardId;

	private Long		marca;
	private Long		exemptId;
	private Integer		codZona;
	private String		sector;
	private String		rind;
	private String		pozitie;
	private Integer		nrLocuri;
	private Integer		ani;
	private Date		dataIncep;
	private Date		dataExp;
	private String		nrCh;
	private Date		dataCh;
	private BigDecimal	suma;
	private String		contract;
	private String		nrContr;
	private Date		dataContr;
	private Integer		ind;
	private String		stare;
	private Date		dataStare;
	private Integer		transe;
	private Integer		codCs;
	private Integer		matricola;
	private String		modif;

	public Long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Long getMarca()
	{
		return marca;
	}

	public void setMarca(Long marca)
	{
		this.marca = marca;
	}

	public Long getGraveownerId()
	{
		return graveownerId;
	}

	public void setGraveownerId(long graveownerId)
	{
		this.graveownerId = graveownerId;
	}

	public Long getGraveyardId()
	{
		return graveyardId;
	}

	public void setGraveyardId(long graveyardId)
	{
		this.graveyardId = graveyardId;
	}

	public Long getExemptId()
	{
		return exemptId;
	}

	public void setExemptId(long exemptId)
	{
		this.exemptId = exemptId;
	}

	public Integer getCodZona()
	{
		return codZona;
	}

	public void setCodZona(int codZona)
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

	public void setNrLocuri(int nrLocuri)
	{
		this.nrLocuri = nrLocuri;
	}

	public Integer getAni()
	{
		return ani;
	}

	public void setAni(int ani)
	{
		this.ani = ani;
	}

	public Date getDataIncep()
	{
		return dataIncep;
	}

	public void setDataIncep(Date dataIncep)
	{
		this.dataIncep = dataIncep;
	}

	public Date getDataExp()
	{
		return dataExp;
	}

	public void setDataExp(Date dataExp)
	{
		this.dataExp = dataExp;
	}

	public String getNrCh()
	{
		return nrCh;
	}

	public void setNrCh(String nrCh)
	{
		this.nrCh = nrCh;
	}

	public Date getDataCh()
	{
		return dataCh;
	}

	public void setDataCh(Date dataCh)
	{
		this.dataCh = dataCh;
	}

	public BigDecimal getSuma()
	{
		return suma;
	}

	public void setSuma(BigDecimal suma)
	{
		this.suma = suma;
	}

	public String getContract()
	{
		return contract;
	}

	public void setContract(String contract)
	{
		this.contract = contract;
	}

	public String getNrContr()
	{
		return nrContr;
	}

	public void setNrContr(String nrContr)
	{
		this.nrContr = nrContr;
	}

	public Date getDataContr()
	{
		return dataContr;
	}

	public void setDataContr(Date dataContr)
	{
		this.dataContr = dataContr;
	}

	public Integer getInd()
	{
		return ind;
	}

	public void setInd(int ind)
	{
		this.ind = ind;
	}

	public String getStare()
	{
		return stare;
	}

	public void setStare(String stare)
	{
		this.stare = stare;
	}

	public Date getDataStare()
	{
		return dataStare;
	}

	public void setDataStare(Date dataStare)
	{
		this.dataStare = dataStare;
	}

	public Integer getTranse()
	{
		return transe;
	}

	public void setTranse(int transe)
	{
		this.transe = transe;
	}

	public Integer getCodCs()
	{
		return codCs;
	}

	public void setCodCs(int codCs)
	{
		this.codCs = codCs;
	}

	public Integer getMatricola()
	{
		return matricola;
	}

	public void setMatricola(int matricola)
	{
		this.matricola = matricola;
	}

	public String getModif()
	{
		return modif;
	}

	public void setModif(String modif)
	{
		this.modif = modif;
	}

	@Override
	public String toString()
	{
		return "Grave [id=" + id + ", graveownerId=" + graveownerId + ", graveyardId=" + graveyardId + ", marca="
				+ marca + ", exemptId=" + exemptId + ", codZona=" + codZona + ", sector=" + sector + ", rind=" + rind
				+ ", pozitie=" + pozitie + ", nrLocuri=" + nrLocuri + ", ani=" + ani + ", dataIncep=" + dataIncep
				+ ", dataExp=" + dataExp + ", nrCh=" + nrCh + ", dataCh=" + dataCh + ", suma=" + suma + ", contract="
				+ contract + ", nrContr=" + nrContr + ", dataContr=" + dataContr + ", ind=" + ind + ", stare=" + stare
				+ ", dataStare=" + dataStare + ", transe=" + transe + ", codCs=" + codCs + ", matricola=" + matricola
				+ ", modif=" + modif + "]";
	}
}
