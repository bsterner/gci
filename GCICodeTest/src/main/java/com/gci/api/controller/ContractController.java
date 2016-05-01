package com.gci.api.controller;

import static com.gci.api.Constants.GET_CONTRACTS_URI;
import static com.gci.api.Constants.GET_CONTRACT_URI;
import static com.gci.api.Constants.GET_INVOICES_URI;
import static com.gci.api.Constants.GET_INVOICE_URI;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gci.api.model.contract.Contract;
import com.gci.api.model.contract.ContractType;
import com.gci.api.model.invoice.Invoice;
import com.gci.api.service.ContractService;

/**
 * Handles RESTful service requests for Contracts API. Uses {@link}
 * ContractsService to perform business operations.
 */
@Controller
public class ContractController {

	private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private ContractService contractService;

	@RequestMapping(value = GET_CONTRACT_URI, method = RequestMethod.GET)
	public @ResponseBody Contract getContract(@RequestParam(required = true) final int clientId,
			@RequestParam(required = true) final ContractType type) {
		logger.info("Retrieving contract type [{}] for client ID [{}]", type, clientId);
		Contract contract = contractService.getContract(clientId, type);
		return contract;
	}

	@RequestMapping(value = GET_CONTRACTS_URI, method = RequestMethod.GET)
	public @ResponseBody List<Contract> getAllContracts(@RequestParam(required = true) final int clientId) {
		logger.info("Retrieving contracts for client ID [{}]", clientId);

		return contractService.getAllContracts(clientId);
	}


	@RequestMapping(value = GET_INVOICE_URI, method = RequestMethod.GET)
	public @ResponseBody Invoice getInvoice(@RequestParam(required = true) final int invoiceId) {
		logger.info("Retrieving invoice with ID [{}]", invoiceId);

		return contractService.getInvoice(invoiceId);
	}

	@RequestMapping(value = GET_INVOICES_URI, method = RequestMethod.GET)
	public @ResponseBody List<Invoice> getAllInvoices(@RequestParam(required = true) final int contractId) {
		logger.info("Retrieving all invoices for contract ID [{}]", contractId);

		return contractService.getAllInvoices(contractId);
	}

}
