package com.gci.api.model.contract;

import java.util.List;

import com.gci.api.model.Cost;

public class ServiceOrderContract extends AbstractBaseContract {

	private List<Cost> recurringCosts;

	private List<Cost> nonRecurringCosts;

	public List<Cost> getRecurringCosts() {
		return recurringCosts;
	}

	public void setRecurringCosts(List<Cost> recurringCosts) {
		this.recurringCosts = recurringCosts;
	}

	public List<Cost> getNonRecurringCosts() {
		return nonRecurringCosts;
	}

	public void setNonRecurringCosts(List<Cost> nonRecurringCosts) {
		this.nonRecurringCosts = nonRecurringCosts;
	}

	@Override
	public ContractType getType() {
		return ContractType.SERVICE_ORDER;
	}

}
