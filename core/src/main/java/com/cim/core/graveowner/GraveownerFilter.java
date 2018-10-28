package com.cim.core.graveowner;

public class GraveownerFilter
{
	private Long	id;
	private String	cnp;
	private String	nume;
	private String	prenume;
	private String	localitate;
	private String	judet;
	private String	adresa;

	public GraveownerFilter()
	{
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
		return "GraveownerFilter [id=" + id + ", cnp=" + cnp + ", nume=" + nume + ", prenume=" + prenume
				+ ", localitate=" + localitate + ", judet=" + judet + ", adresa=" + adresa + "]";
	}

	public static class Builder
	{
		private Long	id;
		private String	cnp;
		private String	nume;
		private String	prenume;
		private String	localitate;
		private String	judet;
		private String	adresa;

		public Builder setId(Long id)
		{
			this.id = id;
			return this;
		}

		public Builder setCnp(String cnp)
		{
			this.cnp = cnp;
			return this;
		}

		public Builder setNume(String nume)
		{
			this.nume = nume;
			return this;
		}

		public Builder setPrenume(String prenume)
		{
			this.prenume = prenume;
			return this;
		}

		public Builder setLocalitate(String localitate)
		{
			this.localitate = localitate;
			return this;
		}

		public Builder setJudet(String judet)
		{
			this.judet = judet;
			return this;
		}

		public Builder setAdresa(String adresa)
		{
			this.adresa = adresa;
			return this;
		}

		public GraveownerFilter build()
		{
			GraveownerFilter filter = new GraveownerFilter();
			filter.setId(this.id);
			filter.setCnp(this.cnp);
			filter.setNume(this.nume);
			filter.setPrenume(this.prenume);
			filter.setLocalitate(this.localitate);
			filter.setJudet(this.judet);
			filter.setAdresa(this.adresa);

			return filter;
		}
	}
}
