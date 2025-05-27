package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private PersonalAccount personalAccount;
    private BusinessAccount businessAccount;

    @Before
    public void setUp() {
        personalAccount = new PersonalAccount("Jackson Felipe", "Rua 26 de maio, 225", 1000, "123.123.123-13");
        businessAccount = new BusinessAccount("Felipe do Nascimento", "Rua 26 de maio, 225", 1000, "73.798.618/001-12");
    }

    @Test
    public void depositAddMoneyToAccount() {
        personalAccount.deposit(500);
        businessAccount.deposit(200);

        Assert.assertEquals(1500, personalAccount.getBalance(), 0.01);
        Assert.assertEquals(1200, businessAccount.getBalance(), 0.01);
    }

    @Test
    public void depositMoneyFromAccountInvalid() {
        personalAccount.deposit(-50);
        businessAccount.deposit(0);

        Assert.assertEquals(1000, personalAccount.getBalance(), 0.01);
        Assert.assertEquals(1000, businessAccount.getBalance(), 0.01);
    }

    @Test
    public void withdrawMoneyFromTheAccount() {
        personalAccount.withdraw(200);
        businessAccount.withdraw(100);

        Assert.assertEquals(800, personalAccount.getBalance(), 0.01);
        Assert.assertEquals(900, businessAccount.getBalance(), 0.01);
    }

    @Test
    public void withdrawMoneyFromTheAccountInvalid() {
        personalAccount.withdraw(50000);
        businessAccount.withdraw(90000);

        Assert.assertEquals(1000, personalAccount.getBalance(), 0.01);
        Assert.assertEquals(1000, businessAccount.getBalance(), 0.01);
    }
}