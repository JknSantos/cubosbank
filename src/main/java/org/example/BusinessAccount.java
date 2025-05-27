package org.example;

public class BusinessAccount extends BankAccount {

    private String cnpj;

    public BusinessAccount(String customerName, String billingAddress, double initialBalance, String cnpj) {
        super(customerName, billingAddress, initialBalance);
        this.cnpj = cnpj;
    }

    @Override
    public String getAccountDetails() {

        return "Business Account [CNPJ: " + cnpj + "]";
    }
}
