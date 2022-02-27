package com.evernote.stepDefinitions;

import com.evernote.pages.Dashboard;
import com.evernote.pages.HomePage;
import com.evernote.pages.LoginPage;
import com.evernote.utilities.BrowserUtil;
import com.evernote.utilities.ConfigurationReader;
import com.evernote.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class LoginStepDef {
    // global instance
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();

    @Given("user on the login page")
    public void user_on_the_login_page() {

        String loginUrl = ConfigurationReader.get("url");
        Driver.getDriver().get(loginUrl + "/login");
    }

    @Given("user click the login link")
    public void user_click_the_login_link() {

        homePage.loginLink.click();

    }

    @Then("login form would be present in screen")
    public void login_form_would_be_present_in_screen() {

        Assert.assertTrue(loginPage.loginForm.isDisplayed());
        BrowserUtil.waitFor(2);
    }

    @When("user login without any email")
    public void user_login_without_any_email() {
        loginPage.continueButton.click();
        BrowserUtil.waitFor(3);
    }


    @When("user enter an valid email as {string} and bad password as {string}")
    public void user_enter_an_valid_email_as_and_bad_password_as(String email, String password) {
        loginPage.loginIntoTheApplication(email, password);
        BrowserUtil.waitFor(2);
    }

    @Then("user see the error message {string}")
    public void user_see_the_error_message(String errorMessage) {

        String actualErrorMsg = loginPage.getErrorMessage(errorMessage);
        Assert.assertEquals(errorMessage, actualErrorMsg);
        BrowserUtil.waitFor(2);
    }

    @When("user enter an invalid email as {string}")
    public void user_enter_an_invalid_email_as(String email) {

        loginPage.loginBadRequest(email);
        BrowserUtil.waitFor(2);
    }

    @When("user enter an valid email as {string} and password as {string}")
    public void user_enter_an_valid_email_as_and_password_as(String email, String password) {

        loginPage.loginIntoTheApplication(email, password);

        try {
            if (dashboard.skipButton.isDisplayed()) {
                dashboard.skipButton.click();
            }

        } catch (Exception e) {
            System.out.println("Error occur!");
        }

        BrowserUtil.waitFor(1);


    }

    @Then("note dashboard should displayed")
    public void note_dashboard_should_displayed() {

        BrowserUtil.waitFor(2);
        Assert.assertTrue(dashboard.noteDashboard.isDisplayed());
        BrowserUtil.waitFor(2);
    }


}
