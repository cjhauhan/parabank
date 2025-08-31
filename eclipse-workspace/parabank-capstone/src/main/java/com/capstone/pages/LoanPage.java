package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoanPage extends BasePage {
    private By requestLoan = By.linkText("Request Loan");
    private By amount = By.id("amount");
    private By downPayment = By.id("downPayment");
    private By fromAccount = By.id("fromAccountId");
    private By applyBtn = By.xpath("//input[@value='Apply Now']");
    private By result = By.id("loanStatus");
    public LoanPage(WebDriver driver) { super(driver); }
    public void openRequestLoan() { click(requestLoan); }
    public void applyLoan(String amt, String down) {
        openRequestLoan();
        type(amount, amt);
        type(downPayment, down);
        // select first account if present
        try { new Select($(fromAccount)).selectByIndex(0); } catch (Exception e) {}
        click(applyBtn);
    }
    public String getResult() { return getText(result); }
}
