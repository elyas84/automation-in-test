package com.evernote.pages;

import com.evernote.utilities.BrowserUtil;
import com.evernote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNotePage extends BasePage {

    /**
     * locators
     */

    @FindBy(css = "#gwt-debug-NoteTitleView-textBox")
    public WebElement titleText_input;


    @FindBy(css = "#tinymce")
    public WebElement contentBody;


    @FindBy(css = "#gwt-debug-NoteAttributes-doneButton")
    public WebElement doneButton;

    @FindBy(xpath = "//div[@class='focus-NotesView-Note-snippetContent']")
    public WebElement noteContent;


    @FindBy(css = "#gwt-debug-DialogB-skip")
    public WebElement skipButton;


    @FindBy(xpath = "//div[@class='GJ1NOG4CO3B']")
    public WebElement accountButton;

    @FindBy(xpath = "//div[contains(text(),'Log out')]")
    public WebElement closeAccountButton;
    @FindBy(xpath = "(//div/img[@class=\"GJ1NOG4CCR\"])[1]")
    public WebElement plusIcon;

    @FindBy(xpath = "(//div[@class=\"focus-NotesView-Note-innerSnippetContainer\"])[1]")
    public WebElement latestNote;

    /**
     * Useful methods
     */

    public void createNewNote(String textInput, String content) {
        titleText_input.clear();
        titleText_input.sendKeys(textInput);
        // embedded Iframe handling
        Driver.getDriver().switchTo().frame("entinymce_492_ifr");
        contentBody.click();
        contentBody.clear();
        contentBody.sendKeys(content);
        // switch back to default frame
        Driver.getDriver().switchTo().defaultContent();
        BrowserUtil.waitFor(1);
        doneButton.click();

    }


    public void closeDashboard() {
        BrowserUtil.waitFor(2);
        closeAccountButton.click();
        BrowserUtil.waitFor(2);


    }

}


