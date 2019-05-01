package com.cim.core.util;

import java.util.Collections;
import java.util.List;

public class ApiListResponse<T>
{
	private Integer	page;
	private Integer	size;
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

	public void setResults(List<T> results)
	{
		this.results = results;
	}

	@Override
	public String toString()
	{
		return "ContractStatusList [page=" + page + ", size=" + size + ", totalPages=" + totalPages + ", totalResults="
				+ totalResults + ", results=" + results + "]";
	}
}
