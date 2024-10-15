package com.bank.bff.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service")
public class ServiceConfig {

    private String customersUrl;
    private String transactionsUrl;
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
