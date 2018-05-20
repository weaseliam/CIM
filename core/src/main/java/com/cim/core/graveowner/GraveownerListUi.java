package com.cim.core.graveowner;

import java.util.List;

public class GraveownerListUi
{
	private Integer				page;
	private Integer				size;
	private String				sort;
	private Integer				totalPages;
	private Long				totalResults;
	private List<GraveownerUi>	graveowners;
	private GraveownerFilterUi	filter;

	public GraveownerListUi()
	{
	}

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

	public List<GraveownerUi> getGraveowners()
	{
		return graveowners;
	}

	public void setGraveowners(List<GraveownerUi> graveowners)
	{
		this.graveowners = graveowners;
	}

	public GraveownerFilterUi getFilter()
	{
		return filter;
	}

	public void setFilter(GraveownerFilterUi filter)
	{
		this.filter = filter;
	}

	@Override
	public String toString()
	{
		return "GraveownerListUi [page=" + page + ", size=" + size + ", sort=" + sort + ", totalPages=" + totalPages
				+ ", totalResults=" + totalResults + ", graveowners=" + graveowners + ", filter=" + filter + "]";
	}
}
