package org.example;

public class PersonalAccount extends BankAccount{
    private String cpf;

    public PersonalAccount(String customerName, String billingAddress, double initialBalance, String password, String cpf) {
        super(customerName, billingAddress, initialBalance, password);
        this.cpf = cpf;
    }

    @Override
    public String getAccountDetails() {

        return "Personal Account [CPF: " + cpf + "]";
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }
}
