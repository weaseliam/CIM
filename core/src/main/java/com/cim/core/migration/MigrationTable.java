package com.cim.core.migration;

public class MigrationTable
{
	private String	name;
	private Long	rows;

	public MigrationTable()
	{
	}

	public MigrationTable(String name)
	{
		this.setName(name);
	}

	public MigrationTable(String name, long rows)
	{
		this.setName(name);
		this.setRows(rows);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Long getRows()
	{
		return rows;
	}

	public void setRows(long rows)
	{
		this.rows = rows;
	}

	@Override
	public String toString()
	{
		return "MigrationTable [name=" + name + ", rows=" + rows + "]";
	}
}
