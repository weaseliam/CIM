package com.cim.core.migration;

import java.util.ArrayList;
import java.util.List;

public class MigrationResponse
{
	private Integer					totalTables;
	private List<MigrationTable>	tables;
	private Long					durationSeconds;

	public MigrationResponse()
	{
	}

	public void addTable(String name, long rows)
	{
		MigrationTable table = new MigrationTable(name, rows);
		getTables().add(table);
	}

	public int getTotalTables()
	{
		if (totalTables == null)
		{
			totalTables = getTables().size();
		}

		return totalTables;
	}

	public void setTotalTables(int totalTables)
	{
		this.totalTables = totalTables;
	}

	public List<MigrationTable> getTables()
	{
		if (tables == null)
		{
			tables = new ArrayList<>();
		}

		return tables;
	}

	public void setTables(List<MigrationTable> tables)
	{
		this.tables = tables;
	}

	public Long getDurationSeconds()
	{
		return durationSeconds;
	}

	public void setDurationSeconds(Long durationSeconds)
	{
		this.durationSeconds = durationSeconds;
	}

	@Override
	public String toString()
	{
		return "MigrationResponse [totalTables=" + totalTables + ", tables=" + tables + ", durationSeconds="
				+ durationSeconds + "]";
	}
}
