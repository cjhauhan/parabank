package com.capstone.tests;

import com.capstone.pages.LoginPage;
import com.capstone.pages.TransferPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTests extends BaseTest {

    @Test
    public void transferFlow() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        lp.login("john", "demo");
        TransferPage t = new TransferPage(driver);
        t.transfer("50");
        Assert.assertTrue(t.isComplete(), "Transfer should complete");
    }
}
