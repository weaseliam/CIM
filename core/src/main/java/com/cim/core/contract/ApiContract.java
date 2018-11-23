package com.cim.core.contract;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class ApiContract
{
	private Long			id;
	private Long			graveownerId;
	private Long			graveId;
	private Long			exemptId;
	private Integer			ani;
	private LocalDateTime	dataIncep;
	private LocalDateTime	dataExp;
	private String			nrContr;
	private LocalDateTime	dataContr;
	private Integer			matricola;

	public ApiContract()
	{
	}

	public ApiContract(@NotNull Contract contr)
	{
		id = contr.getId();
		graveownerId = contr.getGraveownerId();
		graveId = contr.getGraveId();
		exemptId = contr.getExemptId();
		ani = contr.getAni();
		dataIncep = contr.getDataIncep();
		dataExp = contr.getDataExp();
		nrContr = contr.getNrContr();
		dataContr = contr.getDataContr();
		matricola = contr.getMatricola();
	}

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
		return "ApiContract [id=" + id + ", graveownerId=" + graveownerId + ", graveId=" + graveId + ", exemptId="
				+ exemptId + ", ani=" + ani + ", dataIncep=" + dataIncep + ", dataExp=" + dataExp + ", nrContr="
				+ nrContr + ", dataContr=" + dataContr + ", matricola=" + matricola + "]";
	}
}
