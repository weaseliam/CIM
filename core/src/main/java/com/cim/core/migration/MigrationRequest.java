package com.cim.core.migration;

import java.util.LinkedHashMap;
import java.util.Properties;

public class MigrationRequest
{
	private String							driverClassName;
	private String							dbUrl;
	private String							dbUsername;
	private String							dbPassword;
	private Properties						dbProperties;
	private LinkedHashMap<String, String>	tablesMapping;

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
		if (dbProperties == null)
		{
			dbProperties = new Properties();
		}

		return dbProperties;
	}

	public void setDbProperties(Properties dbProperties)
	{
		this.dbProperties = dbProperties;
	}

	public LinkedHashMap<String, String> getTablesMapping()
	{
		if (tablesMapping == null)
		{
			tablesMapping = new LinkedHashMap<>();
		}

		return tablesMapping;
	}

	public void setTablesMapping(LinkedHashMap<String, String> tablesMapping)
	{
		this.tablesMapping = tablesMapping;
	}

	@Override
	public String toString()
	{
		return "MigrationRequest [driverClassName=" + driverClassName + ", dbUrl=" + dbUrl + ", dbUsername="
				+ dbUsername + ", dbPassword=" + dbPassword + ", dbProperties=" + dbProperties + ", tablesMapping="
				+ tablesMapping + "]";
	}
}
