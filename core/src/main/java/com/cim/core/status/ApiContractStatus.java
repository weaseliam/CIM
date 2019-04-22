package com.cim.core.status;

import javax.validation.constraints.NotNull;

import com.cim.core.contract.ApiContract;
import com.cim.core.contract.ContractFull;
import com.cim.core.grave.ApiGrave;
import com.cim.core.graveowner.ApiGraveowner;

public class ApiContractStatus
{
	private ApiContract		contract;
	private ApiGrave		grave;
	private ApiGraveowner	graveowner;

	public ApiContractStatus(@NotNull ContractFull contract)
	{
		this.contract = new ApiContract(contract.getContract());
		this.grave = new ApiGrave(contract.getGrave());
		this.graveowner = new ApiGraveowner(contract.getGraveowner());
	}

	public ApiContract getContract()
	{
		return contract;
	}

	public void setContract(ApiContract contract)
	{
		this.contract = contract;
	}

	public ApiGrave getGrave()
	{
		return grave;
	}

	public void setGrave(ApiGrave grave)
	{
		this.grave = grave;
	}

	public ApiGraveowner getGraveowner()
	{
		return graveowner;
	}

	public void setGraveowner(ApiGraveowner graveowner)
	{
		this.graveowner = graveowner;
	}

	@Override
	public String toString()
	{
		return "ApiContractStatus [contract=" + contract + ", grave=" + grave + ", graveowner=" + graveowner + "]";
	}
}
