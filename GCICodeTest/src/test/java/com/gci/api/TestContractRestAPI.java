//package com.gci.api;
//
//import static com.gci.api.Constants.GET_ALL_CONTRACTS_URI;
//import static com.gci.api.Constants.SERVER_URI;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.client.RestTemplate;
//
//import com.gci.api.model.contract.Contract;
//
//public class TestContractRestAPI {
//
//	private static final Logger logger = LoggerFactory
//			.getLogger(TestContractRestAPI.class);
//
//	public static void main(String args[]) {
//		testCreateContract();
//		logger.info("*****");
//		testGetContract();
//		logger.info("*****");
//		testGetAllContracts();
//		logger.info("*****");
//		testGetContractWithQuery();
//	}
//
//	private static void testGetAllContracts() {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = buildRestUrl(SERVER_URI, GET_ALL_CONTRACTS_URI);
//		List<LinkedHashMap> contracts = restTemplate.getForObject(url, List.class);
//		logger.info(String.format("Number of contracts: [%d]", contracts.size()));
//		for (LinkedHashMap map : contracts) {
//			logger.info("ID [ {} ] ; Body [ {} ]", map.get("id"), map.get("body"));
//		}
//	}
//
//	private static void testGetContract() {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = buildRestUrl(SERVER_URI,
//				String.format("%s%s", GET_ALL_CONTRACTS_URI, "/0"));
//		Contract contract = restTemplate.getForObject(url, Contract.class);
//		printContracts(contract);
//	}
//
//	private static String buildRestUrl(String serverUri, String restServiceUri) {
//		String url = String.format("%s%s", serverUri, restServiceUri);
//		logger.info("Built RESTful URL: {}", url);
//		return url;
//	}
//
//	public static void printContracts(Contract contract) {
//		//logger.info("ContractID [ {} ] : body [ {} ]", contract.getId(), contract.getBody());
//	}
//
//}
