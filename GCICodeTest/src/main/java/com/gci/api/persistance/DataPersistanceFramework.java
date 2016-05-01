package com.gci.api.persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import com.gci.api.Constants;
import com.gci.api.exception.InvalidContractTypeException;
import com.gci.api.model.Cost;
import com.gci.api.model.LineItem;
import com.gci.api.model.NonRecurringCost;
import com.gci.api.model.RecurringCost;
import com.gci.api.model.contract.Contract;
import com.gci.api.model.contract.ContractType;
import com.gci.api.model.contract.LineItemContract;
import com.gci.api.model.contract.ServiceAgreementContract;
import com.gci.api.model.contract.ServiceOrderContract;
import com.gci.api.model.contract.Term;
import com.gci.api.model.invoice.Invoice;
import com.gci.api.model.invoice.InvoiceImpl;
import com.gci.api.model.invoice.InvoiceStatus;
import com.gci.api.util.ContractUtil;

public class DataPersistanceFramework {

	private static volatile DataPersistanceFramework instance;
	
	private List<Contract> contracts = new ArrayList<Contract>();

	private DataPersistanceFramework() {
		buildContracts();
	}

	private void buildContracts() {
		Contract serviceAgreement = createServiceAgreement();
		Contract lineItemContract = createLineItemContract();
		Contract serviceOrderContract = createServiceOrderContract();

		contracts.add(lineItemContract);
		contracts.add(serviceAgreement);
		contracts.add(serviceOrderContract);
	}

	public static DataPersistanceFramework getInstance() {
		if (instance == null) {
			synchronized (DataPersistanceFramework.class) {
				instance = new DataPersistanceFramework();
			}
		}

		return instance;
	}

	public Contract getContract(int clientId, ContractType type) {
		Contract contract;

		switch (type) {
		case LINE_ITEM:
			contract = createLineItemContract();
			break;
		case SERVICE_AGREEMENT:
			contract = createServiceAgreement();
			break;
		case SERVICE_ORDER:
			contract = createServiceOrderContract();
			break;
		default:
			throw new InvalidContractTypeException("Contranct type [{}] is not defined.", type);
		}

		return contract;
	}

	private List<Invoice> createInvoices() {
		List<Invoice> invoices = new ArrayList<Invoice>(2);
		
		Invoice invoice1 = new InvoiceImpl(InvoiceStatus.PAID);
		invoices.add(invoice1);
		
		Invoice invoice2 = new InvoiceImpl(InvoiceStatus.PAST_DUE);
		invoices.add(invoice2);

		return invoices;
	}

	private Contract createLineItemContract() {
		List<LineItem> lineItems = new ArrayList<LineItem>();
		for (int j = 0; j < 3; j++) {
			LineItem lineItem = new LineItem();
			lineItem.setPrice(100.12);
			lineItem.setService(ContractUtil.createRandomServiceName());
			lineItem.setSite(ContractUtil.createRandomSiteName());
			lineItems.add(lineItem);
		}

		LineItemContract contract = new LineItemContract();
		contract.setStartDate(new Date());
		contract.setEndDate(new Date());
		contract.setLineItems(lineItems);
		contract.setInvoices(createInvoices());
		contract.setTerm(new Term("2-Year Term"));
		contract.setId(RandomStringUtils.randomAlphanumeric(Constants.RANDOM_ID_LENGTH));

		return contract;
	}

	private Contract createServiceAgreement() {
		ServiceAgreementContract contract = new ServiceAgreementContract();
		contract.setEndDate(new Date());
		contract.setProjectSummary("This SOW covers the discovery and documentation...");
		contract.setScopeOfWork("Document and Evaluate IP address...");
		contract.setInvoices(createInvoices());
		contract.setTerm(new Term("1-Year Term (up to 160 hours)"));
		contract.setId(RandomStringUtils.randomAlphanumeric(Constants.RANDOM_ID_LENGTH));

		return contract;
	}

	private Contract createServiceOrderContract() {
		List<Cost> recurringCosts = new ArrayList<Cost>();
		RecurringCost recurringCost = new RecurringCost();
		recurringCost.setDescription("Remote Site VPN");
		recurringCost.setPrice(275.00);
		recurringCosts.add(recurringCost);

		List<Cost> nonRecurringCosts = new ArrayList<Cost>();
		NonRecurringCost nonRecurringCost = new NonRecurringCost();
		nonRecurringCost.setDescription("Configuration and Testing Equipment");
		nonRecurringCost.setPrice(3485.00);
		nonRecurringCosts.add(nonRecurringCost);

		ServiceOrderContract contract = new ServiceOrderContract();
		contract.setNonRecurringCosts(nonRecurringCosts);
		contract.setRecurringCosts(recurringCosts);
		contract.setEndDate(new Date());
		contract.setInvoices(createInvoices());
		contract.setTerm(new Term("3-Year Term"));
		contract.setId(RandomStringUtils.randomAlphanumeric(Constants.RANDOM_ID_LENGTH));

		return contract;
	}

	public List<Contract> getContracts(int clientId) {
		return contracts;
	}

	public List<Invoice> getInvoices(int contractId) {
	    return contracts.get(1).getInvoices();
    }

	public Invoice getInvoice(int invoiceId) {
	   return contracts.get(1).getInvoices().get(1);
    }
}
