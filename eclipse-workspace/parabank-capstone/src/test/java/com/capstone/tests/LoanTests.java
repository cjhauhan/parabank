package com.capstone.tests;

import com.capstone.pages.LoanPage;
import com.capstone.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoanTests extends BaseTest {

	private WebDriver driver;

    // Locators
    private By loanAmountField = By.id("amount");
    private By downPaymentField = By.id("downPayment");
    private By fromAccountDrop = By.id("fromAccountId");
    private By applyLoanBtn = By.xpath("//input[@value='Apply Now']");
    private By resultMsg = By.id("loanStatus");

    public void LoanPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open Loan page directly
    public void open() {
        driver.get("https://parabank.parasoft.com/parabank/requestloan.htm");
    }

    // FIX 1: accept String params
    public void applyLoan(String amount, String downPayment) {
        driver.findElement(loanAmountField).clear();
        driver.findElement(loanAmountField).sendKeys(amount);

        driver.findElement(downPaymentField).clear();
        driver.findElement(downPaymentField).sendKeys(downPayment);

        driver.findElement(applyLoanBtn).click();
    }

    // FIX 2: overload for double params (optional)
    public void applyLoan(double amount, double downPayment) {
        applyLoan(String.valueOf(amount), String.valueOf(downPayment));
    }

    // Get decision text (Approved/Denied)
    public String getDecision() {
        return driver.getPageSource().contains("Denied") ? "Denied" : "Approved";
    }

    // FIX 3: Add EMI calculation method
    public double calculateEMI(double principal, double rate, int tenure) {
        // Convert annual rate % to monthly decimal
        double monthlyRate = (rate / 12) / 100;
        return (principal * monthlyRate * Math.pow(1 + monthlyRate, tenure)) /
                (Math.pow(1 + monthlyRate, tenure) - 1);
    }
}