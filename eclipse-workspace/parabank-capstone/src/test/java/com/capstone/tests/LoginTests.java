package com.capstone.tests;

import com.capstone.pages.LoginPage;
import com.capstone.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @DataProvider(name="logins")
    public Object[][] logins() {
        return ExcelUtils.readSheet("src/test/resources/testdata.xlsx", "Logins");
    }

    @Test(dataProvider="logins")
    public void loginTest(Object username, Object password, Object expected) {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        lp.login(String.valueOf(username), String.valueOf(password));
        boolean logged = lp.isLoggedIn();
        if ("pass".equals(String.valueOf(expected))) {
            Assert.assertTrue(logged, "Expected login to pass");
        } else {
            Assert.assertFalse(logged, "Expected login to fail");
        }
    }
}
