package com.cim.core.grave;

import java.util.List;

public class GraveListUi
{
	private Integer			page;
	private Integer			size;
	private String			sort;
	private Integer			totalPages;
	private Long			totalResults;
	private List<GraveUi>	graves;

	public Integer getPage()
	{
		return page;
	}

	public void setPage(Integer page)
	{
		this.page = page;
	}

	public Integer getSize()
	{
		return size;
	}

	public void setSize(Integer size)
	{
		this.size = size;
	}

	public String getSort()
	{
		return sort;
	}

	public void setSort(String sort)
	{
		this.sort = sort;
	}

	public Integer getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(Integer totalPages)
	{
		this.totalPages = totalPages;
	}

	public Long getTotalResults()
	{
		return totalResults;
	}

	public void setTotalResults(Long totalResults)
	{
		this.totalResults = totalResults;
	}

	public List<GraveUi> getGraves()
	{
		return graves;
	}

	public void setGraves(List<GraveUi> graves)
	{
		this.graves = graves;
	}

	@Override
	public String toString()
	{
		return "GraveListUi [page=" + page + ", size=" + size + ", sort=" + sort + ", totalPages=" + totalPages
				+ ", totalResults=" + totalResults + ", graves=" + graves + "]";
	}
}
