package com.cim.core.invoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

// @Entity
public class Invoice
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long			id;

	@NotNull
	private Long			graveownerId;

	@NotNull
	private Long			graveyardId;

	private Long			oldId;
	private String			seria;
	private Long			numar;
	private LocalDateTime	dataFact;
	private LocalDateTime	dataScad;
	private Long			nrcrt;
	private String			denumire;
	private Long			anul;
	private Long			nrlocuri;
	private String			tip;
	private String			fel;
	private Long			ex;

	private BigDecimal		taxaLoc;
	private BigDecimal		pretLoc;
	private BigDecimal		tvaLoc;
	private BigDecimal		valoare;
	private BigDecimal		valTva;
	private BigDecimal		total;
	private BigDecimal		achitat;
	private BigDecimal		ramas;

	private String			nume;
	private String			prenume;
	private String			cnp;
	private String			localitate;
	private String			judet;
	private String			tara;
	private String			str;
	private String			nr;
	private String			bl;
	private String			sc;
	private String			et;
	private String			ap;
	private String			codPost;
}
