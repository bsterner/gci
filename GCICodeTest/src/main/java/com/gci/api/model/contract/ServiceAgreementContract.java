package com.gci.api.model.contract;


public class ServiceAgreementContract extends AbstractBaseContract {

	private String projectSummary;
	
	private String scopeOfWork;
	
	public String getProjectSummary() {
		return projectSummary;
	}

	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}

	public String getScopeOfWork() {
		return scopeOfWork;
	}

	public void setScopeOfWork(String scopeOfWork) {
		this.scopeOfWork = scopeOfWork;
	}

	@Override
    public ContractType getType() {
		return ContractType.SERVICE_AGREEMENT;
    }

}
