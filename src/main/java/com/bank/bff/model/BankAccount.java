package com.bank.bff.model;

import java.math.BigDecimal;
import java.util.List;

public class BankAccount {
    private String uuid;
    private BigDecimal balance;
    private String customerUuid;
    private String customerName;

    private List<Transaction> transactions;

    public BankAccount() {
    }

    public BankAccount(String uuid, String customerUuid, BigDecimal balance) {
        this.uuid = uuid;
        this.balance = balance;
        this.customerUuid = customerUuid;
    }

    public BankAccount(BigDecimal balance, String customerUuid, String customerName) {
        this.balance = balance;
        this.customerUuid = customerUuid;
        this.customerName = customerName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomerUuid() {
        return customerUuid;
    }

    public void setCustomerUuid(String customerUuid) {
        this.customerUuid = customerUuid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
