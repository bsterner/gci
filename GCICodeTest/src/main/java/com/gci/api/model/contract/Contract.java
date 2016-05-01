package com.gci.api.model.contract;

import java.util.Date;
import java.util.List;

import com.gci.api.model.invoice.Invoice;

public interface Contract {

	public void setId(String id);

	public void setStartDate(Date date);

	public void setEndDate(Date date);
	
	public void setInvoices(List<Invoice> date);

	public String getId();

	public Date getStartDate();

	public Date getEndDate();
	
	public List<Invoice> getInvoices();
	
	public boolean isExpiring();

	public ContractType getType();
	
	public Term getTerm();

}
