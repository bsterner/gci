package com.gci.api.model.contract;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.gci.api.model.invoice.Invoice;

public abstract class AbstractBaseContract implements Contract {

	private String id;

	private Date startDate;

	private Date endDate;

	private List<Invoice> invoices;
	
	private Term term;

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	@Override
	public void setStartDate(Date date) {
		this.startDate = date;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getId() {
		return id;
	}

	@Override
	public List<Invoice> getInvoices() {
		return invoices;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean isExpiring() {
		if (endDate == null) {
			return false;
		}
		return (endDate.getTime() - new Date().getTime()) < TimeUnit.MILLISECONDS.convert(90, TimeUnit.DAYS);
	}

	public Term getTerm() {
	    return term;
    }

	public void setTerm(Term term) {
	    this.term = term;
    }

}
