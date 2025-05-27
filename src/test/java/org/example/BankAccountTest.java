package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private PersonalAccount personalAccount;

    @Before
    public void setUp() {
        personalAccount = new PersonalAccount("Jackson Felipe", "Rua 26 de maio, 225", 1000, "123.123.123-13");
    }

    @Test
    public void depositAddMoneyToAccount() {
        personalAccount.deposit(500);

        Assert.assertEquals(1500, personalAccount.getBalance(), 0.01);
    }
}