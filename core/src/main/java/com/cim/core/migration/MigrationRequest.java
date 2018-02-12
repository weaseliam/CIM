package com.cim.core.migration;

import java.util.Properties;

public class MigrationRequest
{
	private String		driverClassName;
	private String		dbUrl;
	private String		dbUsername;
	private String		dbPassword;
	private Properties	dbProperties;

	public MigrationRequest()
	{
	}

	public String getDriverClassName()
	{
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}

	public String getDbUrl()
	{
		return dbUrl;
	}

	public void setDbUrl(String dbUrl)
	{
		this.dbUrl = dbUrl;
	}

	public String getDbUsername()
	{
		return dbUsername;
	}

	public void setDbUsername(String dbUsername)
	{
		this.dbUsername = dbUsername;
	}

	public String getDbPassword()
	{
		return dbPassword;
	}

	public void setDbPassword(String dbPassword)
	{
		this.dbPassword = dbPassword;
	}

	public Properties getDbProperties()
	{
		return dbProperties;
	}

	public void setDbProperties(Properties dbProperties)
	{
		this.dbProperties = dbProperties;
	}

	@Override
	public String toString()
	{
		return "MigrationRequest [driverClassName=" + driverClassName + ", dbUrl=" + dbUrl + ", dbUsername="
				+ dbUsername + ", dbPassword=" + dbPassword + ", dbProperties=" + dbProperties + "]";
	}
}
