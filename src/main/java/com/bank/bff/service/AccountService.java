package com.bank.bff.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private final ServiceConfig serviceConfig;
    private final TransactionService transactionService;
    private final RestTemplate restTemplate;

    public AccountService(ServiceConfig serviceConfig, RestTemplate restTemplate, TransactionService transactionService) {
        this.serviceConfig = serviceConfig;
        this.restTemplate = restTemplate;
        this.transactionService = transactionService;
    }

    public String createNewAccountForCustomer(String customerUuid, BigDecimal initialCredit, String customerName ) {
        String url = serviceConfig.getAccountsUrl() + "/new";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("customerUuid", customerUuid);

        if (initialCredit != null && initialCredit.compareTo(BigDecimal.ZERO) > 0) {
            requestBody.put("balance", initialCredit);
            String uuid = restTemplate.postForObject(url, requestBody, String.class);
            if (uuid != null) {
                return transactionService.createNewTransactionForAccount(uuid, initialCredit, customerName);
            } else {
                throw new RuntimeException("Account creation failed or returned null");
            }
        }
        else {
                initialCredit = BigDecimal.ZERO;
                requestBody.put("initialCredit", initialCredit );
                return restTemplate.postForObject(url, requestBody, String.class);
            }

    }
    public String getAccountsByCustomerUuid(String uuid) {
        String url = serviceConfig.getAccountsUrl() + "/byCustomerId/" + uuid;
        return restTemplate.getForObject(url, String.class);
    }
}
