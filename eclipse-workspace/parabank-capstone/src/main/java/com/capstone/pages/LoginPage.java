package com.capstone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//input[@value='Log In']");
    private By logoutLink = By.linkText("Log Out");
    private String url = "http://parabank.parasoft.com/parabank/index.htm";
    public LoginPage(WebDriver driver) { super(driver); }
    public void open() { driver.get(url); }
    public void login(String user, String pass) { type(username, user); type(password, pass); click(loginBtn); }
    public boolean isLoggedIn() { try { return driver.getPageSource().contains("Log Out") || $(logoutLink) != null; } catch (Exception e) { return false; } }
}
