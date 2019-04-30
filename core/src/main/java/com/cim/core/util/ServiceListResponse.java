package com.cim.core.util;

import java.util.Collections;
import java.util.List;

public class ServiceListResponse<T>
{
	private Integer	page;
	private Integer	size;
	private String	sort;
	private Integer	totalPages;
	private Long	totalResults;
	private List<T>	results;

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

	public List<T> getResults()
	{
		if (results == null)
		{
			results = Collections.emptyList();
		}

		return results;
	}

	public void setResults(List<T> response)
	{
		this.results = response;
	}

	@Override
	public String toString()
	{
		return "ServiceListResponse [page=" + page + ", size=" + size + ", sort=" + sort + ", totalPages=" + totalPages
				+ ", totalResults=" + totalResults + ", results=" + results + "]";
	}
}
