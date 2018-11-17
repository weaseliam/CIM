package com.cim.core.contract;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

	public class Contract
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long			id;

	@NotNull
	private Long			graveownerId;

	@NotNull
	private Long			graveId;

	private Long			exemptId;

	private Long			oldId;
	private Integer			ani;
	private LocalDateTime	dataIncep;
	private LocalDateTime	dataExp;
	private String			nrCh;
	private LocalDateTime	dataCh;
	private BigDecimal		suma;
	private String			contract;
	private String			nrContr;
	private LocalDateTime	dataContr;
	private Integer			ind;
	private String			stare;
	private LocalDateTime	dataStare;
	private Integer			transe;
	private Integer			codCs;
	private Integer			matricola;
	private String			modif;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getGraveownerId()
	{
		return graveownerId;
	}
	
	public void setGraveownerId(Long graveownerId)
	{
		this.graveownerId = graveownerId;
	}
	
	public Long getGraveId()
	{
		return graveId;
	}
	
	public void setGraveId(Long graveId)
	{
		this.graveId = graveId;
	}
	
	public Long getExemptId()
	{
		return exemptId;
	}
	
	public void setExemptId(Long exemptId)
	{
		this.exemptId = exemptId;
	}
	
	public Long getOldId()
	{
		return oldId;
	}
	
	public void setOldId(Long oldId)
	{
		this.oldId = oldId;
	}
	
	public Integer getAni()
	{
		return ani;
	}
	
	public void setAni(Integer ani)
	{
		this.ani = ani;
	}
	
	public LocalDateTime getDataIncep()
	{
		return dataIncep;
	}
	
	public void setDataIncep(LocalDateTime dataIncep)
	{
		this.dataIncep = dataIncep;
	}
	
	public LocalDateTime getDataExp()
	{
		return dataExp;
	}
	
	public void setDataExp(LocalDateTime dataExp)
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
	
	public LocalDateTime getDataCh()
	{
		return dataCh;
	}
	
	public void setDataCh(LocalDateTime dataCh)
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
	
	public LocalDateTime getDataContr()
	{
		return dataContr;
	}
	
	public void setDataContr(LocalDateTime dataContr)
	{
		this.dataContr = dataContr;
	}
	
	public Integer getInd()
	{
		return ind;
	}
	
	public void setInd(Integer ind)
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
	
	public LocalDateTime getDataStare()
	{
		return dataStare;
	}
	
	public void setDataStare(LocalDateTime dataStare)
	{
		this.dataStare = dataStare;
	}
	
	public Integer getTranse()
	{
		return transe;
	}
	
	public void setTranse(Integer transe)
	{
		this.transe = transe;
	}
	
	public Integer getCodCs()
	{
		return codCs;
	}
	
	public void setCodCs(Integer codCs)
	{
		this.codCs = codCs;
	}
	
	public Integer getMatricola()
	{
		return matricola;
	}
	
	public void setMatricola(Integer matricola)
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
		return "Contract [id=" + id + ", graveownerId=" + graveownerId + ", graveId=" + graveId + ", exemptId="
				+ exemptId + ", oldId=" + oldId + ", ani=" + ani + ", dataIncep=" + dataIncep + ", dataExp=" + dataExp
				+ ", nrCh=" + nrCh + ", dataCh=" + dataCh + ", suma=" + suma + ", contract=" + contract + ", nrContr="
				+ nrContr + ", dataContr=" + dataContr + ", ind=" + ind + ", stare=" + stare + ", dataStare="
				+ dataStare + ", transe=" + transe + ", codCs=" + codCs + ", matricola=" + matricola + ", modif="
				+ modif + "]";
	}
}
