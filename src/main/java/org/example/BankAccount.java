package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private String customerName;
    private String billingAddress;
    private double balance;
    private List<String> transactions;

    public BankAccount(String customerName, String billingAddress, double initialBalance) {
        this.customerName = customerName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.transactions.add("Saldo inicial: " + initialBalance);
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            transactions.add("Depósito: " + amount);
        } else {
            transactions.add("Falha na tentativa de Depósito: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Saque: : " + amount);
        } else {
            transactions.add("Falha na tentativa de Saque: " + amount);
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getBalance() {
        return balance;
    }

    public abstract String getAccountDetails();

    public List<String> getTransactions() {
        return transactions;
    }

    public void printStatement() {
        System.out.println("Extrato de: " + customerName);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("Saldo atual: " + balance);
    }

}

