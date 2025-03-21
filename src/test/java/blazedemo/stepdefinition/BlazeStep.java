package blazedemo.stepdefinition;

import blazedemo.pages.BlazeHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriverbase.BaseDriver;

public class BlazeStep extends BaseDriver {
    BlazeHome webpages;
    @Given("user is on the BlazeDemo page")
    public void userIsOnTheBlazeDemoPage() {
        webpages = new BlazeHome(driver);
        webpages.BlazeDemoPage();
    }

    @When("user select a phone samsung galaxy")
    public void userSelectAPhone() {
        webpages.PhoneSamsungGalaxyS();
    }

    @And("user add to chart")
    public void userAddToChart() {
        webpages.userAddToChart();
    }

    @Then("user should see message {string}")
    public void userShouldSeeMessage(String message) {
        webpages.Message(message);
    }

    @When("user click on cart")
    public void userClickOnCart() {
        webpages.chart();
    }

    @And("user click on place order")
    public void userClickOnPlaceOrder() {
        webpages.placeOrder();
    }

    @Then("user fill the form")
    public void userFillTheForm() {
        webpages.fillingForm();
    }

    @And("user click on purchase")
    public void userClickOnPurchase() {
        webpages.purchaseButton();
    }

    @Then("user should see the purchase message {string}")
    public void userShouldSeeThePurchaseMessage(String finishMessage) {
        webpages.finishOrder(finishMessage);
    }

    @When("user click on Sign Up")
    public void userClickOnSignUp() {
        webpages.userClickOnSignUp();
    }

    @And("user fill the username {string}")
    public void userFillTheUsername(String username) {
        webpages.signinusername(username);
    }

    @And("user fill the password {string}")
    public void userFillThePassword(String password) {
        webpages.signinpassword(password);
    }

    @And("user click on SignupForm")
    public void userClickOnSignupForm() {
        webpages.signinbutton();
    }

    @Then("user should see Sign Up message {string}")
    public void userShouldSeeSignUpMessage(String signupMessage) {
        webpages.signupMessage(signupMessage);
    }

    @When("user click on Log In")
    public void userClickOnLogIn() {
        webpages.userClickOnLogIn();
    }
    @And("user fill the loginusername {string}")
    public void userFillTheLoginusername(String loginusername) {
        webpages.setLoginusernameform(loginusername);
    }
    @And("user fill the loginpassword {string}")
    public void userFillTheLoginpassword(String loginpassword) {
        webpages.setLoginpasswordform(loginpassword);
    }

    @And("user click on LoginForm")
    public void userClickOnLoginform() {
        webpages.userClickOnLoginform();
    }

    @Then("user should see Log In message {string}")
    public void userShouldSeeLogInMessage(String loginmessage) {
        webpages.loginMessage(loginmessage);
    }

    @When("user click on phones")
    public void userClickOnPhones() {
        webpages.choosephoneCategory();
    }

    @Then("user should see phone option")
    public void userShouldSeePhoneOption() {
        webpages.producttitlesphones();
    }

    @When("user click on laptops")
    public void userClickOnLaptops() {
        webpages.chooseLaptopCategory();
    }

    @Then("user should see laptop option")
    public void userShouldSeeLaptopOption() {
        webpages.producttitleslaptops();
    }
}
