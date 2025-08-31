package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferPage extends BasePage {
    private By transferLink = By.linkText("Transfer Funds");
    private By amount = By.id("amount");
    private By fromAcc = By.id("fromAccountId");
    private By toAcc = By.id("toAccountId");
    private By transferBtn = By.xpath("//input[@value='Transfer']");
    private By msg = By.xpath("//h1[contains(text(),'Transfer Complete')]");
    public TransferPage(WebDriver driver) { super(driver); }
    public void openTransfer() { click(transferLink); }
    public void transfer(String amt) {
        openTransfer();
        type(amount, amt);
        try { new Select($(fromAcc)).selectByIndex(0); new Select($(toAcc)).selectByIndex(1); } catch (Exception e) {}
        click(transferBtn);
    }
    public boolean isComplete() { try { return $(msg) != null; } catch (Exception e) { return false; } }
}
