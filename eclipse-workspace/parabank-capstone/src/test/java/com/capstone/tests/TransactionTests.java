package com.capstone.tests;

import com.capstone.pages.LoginPage;
import com.capstone.pages.TransactionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionTests extends BaseTest {
    @Test
    public void transactionHistory() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        lp.login("john", "demo");
        TransactionPage t = new TransactionPage(driver);
        t.openFirstAccount();
        Assert.assertTrue(t.hasTransactions(), "Should show transactions");
    }
}
