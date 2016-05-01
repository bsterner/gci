package com.gci.api.model.invoice;

import java.util.Date;

public interface Invoice {
	
	public String getId();
	
	public InvoiceStatus getStatus();
	
	public Date dueDate();

}
