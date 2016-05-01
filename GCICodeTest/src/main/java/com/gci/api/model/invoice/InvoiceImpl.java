package com.gci.api.model.invoice;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

import com.gci.api.Constants;
import com.gci.api.util.ContractUtil;

public class InvoiceImpl implements Invoice {

	private Date dueDate = ContractUtil.createRandomDate(30);

	private String id = RandomStringUtils.randomAlphanumeric(Constants.RANDOM_ID_LENGTH);

	private InvoiceStatus status;

	public InvoiceImpl(InvoiceStatus status) {
		this.status = status;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public InvoiceStatus getStatus() {
		return status;
	}

	@Override
	public Date dueDate() {
		return dueDate;
	}

}
