package com.cim.core.migration;

public class MigrationTable
{
	private String	source;
	private String	target;
	private Long	rows;

	public MigrationTable()
	{
	}

	public MigrationTable(String source, String target, Long rows)
	{
		super();
		this.source = source;
		this.target = target;
		this.rows = rows;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public Long getRows()
	{
		return rows;
	}

	public void setRows(Long rows)
	{
		this.rows = rows;
	}

	@Override
	public String toString()
	{
		return "MigrationTable [source=" + source + ", target=" + target + ", rows=" + rows + "]";
	}
}
