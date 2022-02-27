package com.evernote.stepDefinitions;

import com.evernote.pages.CreateNotePage;
import com.evernote.utilities.BrowserUtil;
import com.evernote.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class CreateNoteStepDef {

    CreateNotePage createNotePage = new CreateNotePage();


    @Then("user types {string} in the title input and {string} in the content area and click the done button")
    public void user_types_in_the_title_input_and_in_the_content_area_and_click_the_done_button(String title, String content) {

        //createNotePage.skipButton.click();

        createNotePage.titleText_input.clear();

        createNotePage.createNewNote(title, content);
        BrowserUtil.waitFor(3);

    }

    @Then("created note should be displayed in list")
    public void created_note_should_be_displayed_in_list() {

        Assert.assertTrue(createNotePage.noteContent.isDisplayed());
        BrowserUtil.waitFor(2);

    }

    @Then("user click on the account button")
    public void user_click_on_the_account_button() {

        createNotePage.accountButton.click();
    }

    @When("user click the logout button")
    public void user_click_the_logout_button() {

        createNotePage.closeDashboard();

    }

    @Then("user should redirected to home page and url should be same with {string}")
    public void user_should_redirected_to_home_page_and_url_should_be_same_with(String expectedUrl) {

        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        BrowserUtil.waitFor(1);
    }


    @When("user click on the plus icon")
    public void user_click_on_the_plus_icon() {

        createNotePage.plusIcon.click();
        BrowserUtil.waitFor(1);
    }

    @Then("latest note should be present first place in the note list")
    public void latest_note_should_be_present_first_place_in_the_note_list() {

        Assert.assertTrue(createNotePage.latestNote.isDisplayed());
        BrowserUtil.waitFor(2);
    }

}
