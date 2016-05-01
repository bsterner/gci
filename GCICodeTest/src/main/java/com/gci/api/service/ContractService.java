package com.gci.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gci.api.dao.ContractDao;
import com.gci.api.model.contract.Contract;
import com.gci.api.model.contract.ContractType;
import com.gci.api.model.invoice.Invoice;

/**
 * Contracts service handles "business service operations" for Contracts API.
 * Primarily used by ContractsController as proxy to ContractsDao.
 */
@Service
public class ContractService {

	@Autowired
	private ContractDao contractDao;

	public Contract getContract(int clientId, ContractType type) {
		return contractDao.getContract(clientId, type);
	}

	public List<Contract> getAllContracts(int clientId) {
		return contractDao.getAllContracts(clientId);
	}

	public Invoice getInvoice(int invoiceId) {
	    return contractDao.getInvoice(invoiceId);
    }

	public List<Invoice> getAllInvoices(int contractId) {
	    return contractDao.getAllInvoices(contractId);
    }

}