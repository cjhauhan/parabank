package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends BasePage {
    private By openNew = By.linkText("Open New Account");
    private By type = By.id("type");
    private By fromAccount = By.id("fromAccountId");
    private By openBtn = By.xpath("//input[@value='Open New Account']");
    private By newAccountId = By.id("newAccountId");
    public AccountPage(WebDriver driver) { super(driver); }
    public void openNewAccount(String acctType) {
        click(openNew);
        try { new Select($(type)).selectByVisibleText(acctType); } catch (Exception e) {}
        try { new Select($(fromAccount)).selectByIndex(0); } catch (Exception e) {}
        click(openBtn);
    }
    public String getNewAccountId() { return getText(newAccountId); }
}
