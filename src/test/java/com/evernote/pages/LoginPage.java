package com.evernote.pages;

import com.evernote.utilities.BrowserUtil;
import com.evernote.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage() {
    }

    /**
     * locators
     */

    @FindBy(css = ".minimal-body")
    public WebElement loginForm;

    @FindBy(css = "#username")
    public WebElement emailInput_filed;

    @FindBy(css = "#loginButton")
    public WebElement continueButton;

    @FindBy(css = "#password")
    public WebElement passwordInput_Filed;

    @FindBy(css = "#loginButton")
    public WebElement signInButton;


    /**
     * useful methods
     */


    public void loginBadRequest(String email) {

        emailInput_filed.sendKeys(email);
        continueButton.click();

    }

    public void loginIntoTheApplication(String email, String password) {

        emailInput_filed.sendKeys(email);
        BrowserUtil.waitFor(2);
        continueButton.click();
        passwordInput_Filed.sendKeys(password);
        signInButton.click();
    }

    public String getErrorMessage(String errorText) {
        String errorMessage = Driver.getDriver().findElement(By.xpath("//div[contains(text(), '" + errorText + "')]")).getText();

        return  errorMessage;
    }
}
