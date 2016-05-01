package com.gci.api.persistence;

import java.util.List;

import com.gci.api.model.contract.Contract;

public interface ContractMapper {

	List<Contract> getAllContracts(String query);

	Contract getContract(int id);

	void insertContract(Contract contract);

}
