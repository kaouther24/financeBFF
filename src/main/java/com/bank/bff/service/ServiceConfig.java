package com.bank.bff.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Value("${service.customers.url}")
    private String customersUrl;
    @Value("${service.transactions.url}")
    private String transactionsUrl;
    @Value("${service.accounts.url}")
    private String accountsUrl;

    public String getCustomersUrl() {
        return customersUrl;
    }

    public void setCustomersUrl(String customersUrl) {
        this.customersUrl = customersUrl;
    }

    public String getTransactionsUrl() {
        return transactionsUrl;
    }

    public void setTransactionsUrl(String transactionsUrl) {
        this.transactionsUrl = transactionsUrl;
    }

    public String getAccountsUrl() {
        return accountsUrl;
    }

    public void setAccountsUrl(String accountsUrl) {
        this.accountsUrl = accountsUrl;
    }
}
