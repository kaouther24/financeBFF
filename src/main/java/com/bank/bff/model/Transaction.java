package com.bank.bff.model;


import java.math.BigDecimal;

public class Transaction {
    private String uuid;
    private BigDecimal amount;
    private String creditor;
    private String debtor;
    private String accountUuid;
    private String reference;
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, String creditor, String debtor, String accountUuid, String reference, TransactionType transactionType) {
        this.amount = amount;
        this.creditor = creditor;
        this.debtor = debtor;
        this.accountUuid = accountUuid;
        this.reference = reference;
        this.transactionType = transactionType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public void setAccountUuid(String accountUuid) {
        this.accountUuid = accountUuid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
