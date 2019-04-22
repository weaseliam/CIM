package com.cim.core.util;

import java.util.Collections;
import java.util.List;

public class ApiListResponse<T>
{
	private Integer	page;
	private Integer	size;
	private Integer	totalPages;
	private Long	totalResults;
	private List<T>	response;

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

	public List<T> getResponse()
	{
		if (response == null)
		{
			response = Collections.emptyList();
		}

		return response;
	}

	public void setResponse(List<T> response)
	{
		this.response = response;
	}

	@Override
	public String toString()
	{
		return "ContractStatusList [page=" + page + ", size=" + size + ", totalPages=" + totalPages + ", totalResults="
				+ totalResults + ", response=" + response + "]";
	}
}
