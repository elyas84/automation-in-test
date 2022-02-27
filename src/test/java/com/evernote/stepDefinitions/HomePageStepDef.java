package com.evernote.stepDefinitions;

import com.evernote.pages.HomePage;
import com.evernote.utilities.ConfigurationReader;
import com.evernote.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HomePageStepDef {


    HomePage homepage = new HomePage();

    @Given("user launch the browser")
    public void user_launch_the_browser() {

        Driver.getDriver();
    }

    @When("user navigates to the home page")
    public void user_navigates_to_the_home_page() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.get("url"));
        Thread.sleep(1500);
        homepage.acceptCookie();


    }

    @Then("login link should be displayed")
    public void login_link_should_be_displayed() throws InterruptedException {

        Assert.assertTrue("Login link displays", homepage.loginLink.isDisplayed());

        Thread.sleep(1500);
    }


}
