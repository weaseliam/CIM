package com.cim.core.grave;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class GraveUi
{
	private Long			id;
	private String			cimitir;
	private Integer			codZona;
	private String			sector;
	private String			rand;
	private String			pozitie;
	private Integer			nrLocuri;
	private Integer			ani;
	private String			stare;
	private LocalDateTime	dataStare;
	private LocalDateTime	dataIncep;
	private LocalDateTime	dataExp;
	private Integer			codCs;
	private String			scutit;
	private String			nrCh;
	private LocalDateTime	dataCh;
	private BigDecimal		suma;
	private String			nrContr;
	private LocalDateTime	dataContr;
	private Integer			transe;
	private Integer			matricola;

	public GraveUi()
	{
	}

	public GraveUi(@NotNull Grave grave)
	{
		id = grave.getId();
		cimitir = grave.getGraveyard().getNume();
		codZona = grave.getCodZona();
		sector = grave.getSector();
		rand = grave.getRind();
		pozitie = grave.getPozitie();
		nrLocuri = grave.getNrLocuri();
		ani = grave.getAni();
		stare = grave.getStare();
		dataStare = grave.getDataStare();
		dataIncep = grave.getDataIncep();
		dataExp = grave.getDataExp();
		codCs = grave.getCodCs();
		scutit = grave.getExempt().getNume();
		nrCh = grave.getNrCh();
		dataCh = grave.getDataCh();
		suma = grave.getSuma();
		nrContr = grave.getNrContr();
		dataContr = grave.getDataContr();
		transe = grave.getTranse();
		matricola = grave.getMatricola();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCimitir()
	{
		return cimitir;
	}

	public void setCimitir(String cimitir)
	{
		this.cimitir = cimitir;
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

	public Integer getCodCs()
	{
		return codCs;
	}

	public void setCodCs(Integer codCs)
	{
		this.codCs = codCs;
	}

	public String getScutit()
	{
		return scutit;
	}

	public void setScutit(String scutit)
	{
		this.scutit = scutit;
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

	public Integer getTranse()
	{
		return transe;
	}

	public void setTranse(Integer transe)
	{
		this.transe = transe;
	}

	public Integer getMatricola()
	{
		return matricola;
	}

	public void setMatricola(Integer matricola)
	{
		this.matricola = matricola;
	}

	@Override
	public String toString()
	{
		return "GraveUi [id=" + id + ", cimitir=" + cimitir + ", codZona=" + codZona + ", sector=" + sector + ", rand="
				+ rand + ", pozitie=" + pozitie + ", nrLocuri=" + nrLocuri + ", ani=" + ani + ", stare=" + stare
				+ ", dataStare=" + dataStare + ", dataIncep=" + dataIncep + ", dataExp=" + dataExp + ", codCs=" + codCs
				+ ", scutit=" + scutit + ", nrCh=" + nrCh + ", dataCh=" + dataCh + ", suma=" + suma + ", nrContr="
				+ nrContr + ", dataContr=" + dataContr + ", transe=" + transe + ", matricola=" + matricola + "]";
	}
}
