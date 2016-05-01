package com.gci.api.dao;

import java.util.List;

import com.gci.api.model.contract.Contract;
import com.gci.api.model.contract.ContractType;
import com.gci.api.model.invoice.Invoice;

/**
 * Contract DAO performs uses data persistance framework to perform CRUD operations on Contract(s) 
 */
public interface ContractDao {
	
	/**
	 * Retrieves the individual contract matching the provided id
	 * 
	 * @param id the id of the contract
	 * @return the contract model object
	 */
	public Contract getContract(int clientId, ContractType type);

	/**
	 * Retrieves all contracts for provided client ID.
	 * @param clientId 
	 * 
	 * @return list of all contracts
	 */
	public List<Contract> getAllContracts(int clientId);

	/**
	 * Retrieves all invoices for provided contract ID.
	 * @param contractId 
	 * 
	 * @return list of invoices
	 */
	public List<Invoice> getAllInvoices(int contractId);

	/**
	 * Retrieves the invoice matching the provided invoice Id.
	 * @param invoiceId 
	 * 
	 * @return an invoice instance
	 */
	public Invoice getInvoice(int invoiceId);

}
