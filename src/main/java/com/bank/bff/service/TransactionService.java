package com.bank.bff.service;

import com.bank.bff.model.Transaction;
import com.bank.bff.model.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {
    private final ServiceConfig serviceConfig;
    private final RestTemplate restTemplate;

    public TransactionService(ServiceConfig serviceConfig, RestTemplate restTemplate) {
        this.serviceConfig = serviceConfig;
        this.restTemplate = restTemplate;
    }

    public String getTransactionByAccountUuid(String uuid) {
        String url = serviceConfig.getTransactionsUrl() + "/byAccountUuid/" + uuid;
        return restTemplate.getForObject(url, String.class);
    }

        public String createNewTransactionForAccount(String accountUuid, BigDecimal initialCredit, String customerName) {
        String url = serviceConfig.getTransactionsUrl() + "/new" ;
            Transaction newTransaction = new Transaction(initialCredit,customerName, null, accountUuid,"reference", TransactionType.DEPOSIT);
            return restTemplate.postForObject(url, newTransaction, String.class);
    }
}
