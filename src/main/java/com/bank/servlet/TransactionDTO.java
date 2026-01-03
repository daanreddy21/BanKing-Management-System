package com.bank.servlet;

import java.sql.Timestamp;

public class TransactionDTO {

    private int id;
    private String accountId;
    private String type;          // CREDIT or DEBIT
    private double amount;
    private double balanceAfter;
    private Timestamp txnDate;

    // ----- Getters and Setters -----

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }
    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public Timestamp getTxnDate() {
        return txnDate;
    }
    public void setTxnDate(Timestamp txnDate) {
        this.txnDate = txnDate;
    }
}
