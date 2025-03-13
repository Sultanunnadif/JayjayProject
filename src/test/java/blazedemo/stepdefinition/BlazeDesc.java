package blazedemo.stepdefinition;

import blazedemo.pages.BlazeDescPage;
import io.cucumber.java.en.Then;
import webdriverbase.BaseDriver;

public class BlazeDesc extends BaseDriver {
    BlazeDescPage descPage;
    @Then("user should see the samsung description")
    public void userShouldSeeThePhoneDescription() {
        descPage = new BlazeDescPage(driver);
        descPage.validateProductDescription();
    }
}
