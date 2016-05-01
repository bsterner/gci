package com.gci.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gci.api.model.contract.Contract;
import com.gci.api.model.contract.ContractType;
import com.gci.api.model.invoice.Invoice;
import com.gci.api.persistance.DataPersistanceFramework;

/**
 * Data access implementation is simple data structure. In real production
 * environment data would be retrieved from a database and ideally use some type
 * of persistence framework (MyBatis, Hibernate, TopLink, etc...).
 *
 */
@Repository
public class ContractDaoImpl implements ContractDao {

	@Override
	public Contract getContract(int clientId, ContractType type) {
		return DataPersistanceFramework.getInstance().getContract(clientId, type);
	}

	@Override
	public List<Contract> getAllContracts(int clientId) {
		return DataPersistanceFramework.getInstance().getContracts(clientId);
	}

	@Override
    public List<Invoice> getAllInvoices(int contractId) {
		return DataPersistanceFramework.getInstance().getInvoices(contractId);
    }

	@Override
    public Invoice getInvoice(int invoiceId) {
		return DataPersistanceFramework.getInstance().getInvoice(invoiceId);
    }

}
