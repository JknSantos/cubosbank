package org.example;

public class PersonalAccount extends BankAccount{
    private String cpf;

    public PersonalAccount(String customerName, String billingAddress, double initialBalance, String cpf) {
        super(customerName, billingAddress, initialBalance);
        this.cpf = cpf;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }
}
