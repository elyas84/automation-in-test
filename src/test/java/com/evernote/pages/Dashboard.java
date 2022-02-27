package com.evernote.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {


    /**
     * locators
     */

    @FindBy(css = "#gwt-debug-NoteTitleView-textBox")
    public WebElement noteDashboard;
    @FindBy(css = "#gwt-debug-DialogB-skip")
    public WebElement skipButton;


}

