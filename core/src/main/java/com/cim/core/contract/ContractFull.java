package com.cim.core.contract;

import com.cim.core.grave.Grave;
import com.cim.core.graveowner.Graveowner;

public class ContractFull
{
	private Contract	contract;
	private Graveowner	graveowner;
	private Grave		grave;

	public ContractFull()
	{
	}
	
	public ContractFull(Contract contract, Graveowner graveowner, Grave grave)
	{
		this.contract = contract;
		this.graveowner = graveowner;
		this.grave = grave;
	}

	public Contract getContract()
	{
		return contract;
	}

	public void setContract(Contract contract)
	{
		this.contract = contract;
	}

	public Grave getGrave()
	{
		return grave;
	}

	public void setGrave(Grave grave)
	{
		this.grave = grave;
	}

	public Graveowner getGraveowner()
	{
		return graveowner;
	}

	public void setGraveowner(Graveowner graveowner)
	{
		this.graveowner = graveowner;
	}

	@Override
	public String toString()
	{
		return "ContractFull [contract=" + contract + ", grave=" + grave + ", graveowner=" + graveowner + "]";
	}
}
