package com.cim.core.contract;

import java.util.List;

public class ApiContractList
{
	private Integer				page;
	private Integer				size;
	private String				sort;
	private Integer				totalPages;
	private Long				totalResults;
	private List<ApiContract>	contracts;

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

	public List<ApiContract> getContracts()
	{
		return contracts;
	}

	public void setContracts(List<ApiContract> contracts)
	{
		this.contracts = contracts;
	}

	@Override
	public String toString()
	{
		return "ApiContractList [page=" + page + ", size=" + size + ", sort=" + sort + ", totalPages=" + totalPages
				+ ", totalResults=" + totalResults + ", contracts=" + contracts + "]";
	}
}
