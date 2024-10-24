package com.bank.bff.controller;

import com.bank.bff.model.BankAccount;
import com.bank.bff.model.Customer;
import com.bank.bff.model.Transaction;
import com.bank.bff.service.AccountService;
import com.bank.bff.service.CustomerService;
import com.bank.bff.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final ObjectMapper objectMapper;

    public CustomerController(CustomerService customerService, AccountService accountService, TransactionService transactionService, ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/details/{customerUuid}")
    public Map<String, Object> getCustomerDetails(@PathVariable String customerUuid) throws JsonProcessingException {
        Map<String, Object> customerDetails = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        // Fetch customer details and deserialize
        String customerJson = customerService.getCustomerByUuid(customerUuid);
        Customer customer = objectMapper.readValue(customerJson, Customer.class);
        customerDetails.put("customer", customer);

        // Fetch accounts for the customer and deserialize
        String accountsJson = accountService.getAccountsByCustomerUuid(customerUuid);
        List<BankAccount> accounts = objectMapper.readValue(accountsJson, new TypeReference<List<BankAccount>>(){});

        // For each account, fetch transactions and associate with the account
        for (BankAccount account : accounts) {
            String transactionsJson = transactionService.getTransactionByAccountUuid(account.getUuid());
            List<Transaction> transactions = objectMapper.readValue(transactionsJson, new TypeReference<List<Transaction>>(){});
            account.setTransactions(transactions); // Attach transactions to the account
        }

        customerDetails.put("accounts", accounts);

        return customerDetails;
    }

    // Helper method to extract account UUIDs from JSON string
    private List<String> extractAccountUuids(String accountsJson) throws JsonProcessingException {
        List<String> accountUuids = new ArrayList<>();
        JsonNode accountsArray = objectMapper.readTree(accountsJson);

        for (JsonNode accountNode : accountsArray) {
            String accountUuid = accountNode.get("uuid").asText();
            accountUuids.add(accountUuid);
        }

        return accountUuids;
    }

    // This helper method fetches transactions for each account by its UUID
    private Map<String, String> getTransactionsForAccounts(List<String> accountUuids) {
        Map<String, String> transactionsMap = new HashMap<>();
        for (String accountUuid : accountUuids) {
            String transactions = transactionService.getTransactionByAccountUuid(accountUuid);
            transactionsMap.put(accountUuid, transactions);
        }
        return transactionsMap;
    }
}
