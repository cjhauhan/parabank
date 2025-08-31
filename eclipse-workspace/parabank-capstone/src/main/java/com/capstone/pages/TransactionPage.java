package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage extends BasePage {
    private By accounts = By.linkText("Accounts Overview");
    private By firstAccount = By.cssSelector("#accountTable a");
    private By transTable = By.id("transactionTable");
    public TransactionPage(WebDriver driver) { super(driver); }
    public void openFirstAccount() { click(accounts); click(firstAccount); }
    public boolean hasTransactions() { try { return $(transTable) != null; } catch (Exception e) { return false; } }
}
