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
}