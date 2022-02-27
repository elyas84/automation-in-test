package com.evernote.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    /**
     * locators
     */

    @FindBy(xpath = "//div/a[@class=\"button-primary accept-cookies\"]")
    public WebElement cookie;

    @FindBy(xpath = "//nav[@class=\"utility-nav\"]/ul/li/a[contains(text(), \"Log In\")]")
    public WebElement loginLink;

    /**
     * useful functions/ methods
     */
    public void acceptCookie() {
        cookie.click();
    }


}
