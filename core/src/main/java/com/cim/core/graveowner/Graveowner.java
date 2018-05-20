package com.cim.core.graveowner;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Graveowner
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;

	@NotNull
	private String	nume;

	@NotNull
	private String	prenume;
	
	@NotNull
	private String	adresa;

	private Long	marca;
	private String	cnp;
	private Integer	codLoc;
	private String	localitate;
	private String	judet;
	private String	tara;
	private String	str;
	private String	nr;
	private String	bl;
	private String	sc;
	private String	et;
	private String	ap;
	private String	codPost;
	private String	tel;
	private String	fax;
	private String	mail;
	private String	nrContr;
	private Date	dataContr;
	private String	contract;
	private String	act;
	private String	seria;
	private String	nrAct;
	private String	emitator;
	private Date	dataAct;
	private String	dubiu;
	private Date	dataDubiu;
	private String	avans;
	private Integer	anDebut;
	private Integer	anFinal;
	private String	modif;
	private String	avizat;
	private Date	dataAviz;

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

	public String getCnp()
	{
		return cnp;
	}

	public void setCnp(String cnp)
	{
		this.cnp = cnp;
	}

	public Integer getCodLoc()
	{
		return codLoc;
	}

	public void setCodLoc(int codLoc)
	{
		this.codLoc = codLoc;
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

	public String getTara()
	{
		return tara;
	}

	public void setTara(String tara)
	{
		this.tara = tara;
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

	public String getCodPost()
	{
		return codPost;
	}

	public void setCodPost(String codPost)
	{
		this.codPost = codPost;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
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

	public String getContract()
	{
		return contract;
	}

	public void setContract(String contract)
	{
		this.contract = contract;
	}

	public String getAct()
	{
		return act;
	}

	public void setAct(String act)
	{
		this.act = act;
	}

	public String getSeria()
	{
		return seria;
	}

	public void setSeria(String seria)
	{
		this.seria = seria;
	}

	public String getNrAct()
	{
		return nrAct;
	}

	public void setNrAct(String nrAct)
	{
		this.nrAct = nrAct;
	}

	public String getEmitator()
	{
		return emitator;
	}

	public void setEmitator(String emitator)
	{
		this.emitator = emitator;
	}

	public Date getDataAct()
	{
		return dataAct;
	}

	public void setDataAct(Date dataAct)
	{
		this.dataAct = dataAct;
	}

	public String getDubiu()
	{
		return dubiu;
	}

	public void setDubiu(String dubiu)
	{
		this.dubiu = dubiu;
	}

	public Date getDataDubiu()
	{
		return dataDubiu;
	}

	public void setDataDubiu(Date dataDubiu)
	{
		this.dataDubiu = dataDubiu;
	}

	public String getAvans()
	{
		return avans;
	}

	public void setAvans(String avans)
	{
		this.avans = avans;
	}

	public Integer getAnDebut()
	{
		return anDebut;
	}

	public void setAnDebut(int anDebut)
	{
		this.anDebut = anDebut;
	}

	public Integer getAnFinal()
	{
		return anFinal;
	}

	public void setAnFinal(int anFinal)
	{
		this.anFinal = anFinal;
	}

	public String getModif()
	{
		return modif;
	}

	public void setModif(String modif)
	{
		this.modif = modif;
	}

	public String getAvizat()
	{
		return avizat;
	}

	public void setAvizat(String avizat)
	{
		this.avizat = avizat;
	}

	public Date getDataAviz()
	{
		return dataAviz;
	}

	public void setDataAviz(Date dataAviz)
	{
		this.dataAviz = dataAviz;
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
		return "Graveowner [id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", adresa=" + adresa + ", marca="
				+ marca + ", cnp=" + cnp + ", codLoc=" + codLoc + ", localitate=" + localitate + ", judet=" + judet
				+ ", tara=" + tara + ", str=" + str + ", nr=" + nr + ", bl=" + bl + ", sc=" + sc + ", et=" + et
				+ ", ap=" + ap + ", codPost=" + codPost + ", tel=" + tel + ", fax=" + fax + ", mail=" + mail
				+ ", nrContr=" + nrContr + ", dataContr=" + dataContr + ", contract=" + contract + ", act=" + act
				+ ", seria=" + seria + ", nrAct=" + nrAct + ", emitator=" + emitator + ", dataAct=" + dataAct
				+ ", dubiu=" + dubiu + ", dataDubiu=" + dataDubiu + ", avans=" + avans + ", anDebut=" + anDebut
				+ ", anFinal=" + anFinal + ", modif=" + modif + ", avizat=" + avizat + ", dataAviz=" + dataAviz + "]";
	}
}
