package com.evernote.stepDefinitions;

import com.evernote.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            // screenshot if test is not succeeded
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] capturedData = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(capturedData, "image/png", "ScreenShot");

        }

        Driver.closeDriver();

    }

}
