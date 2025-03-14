package blazedemo.stepdefinition;

import blazedemo.pages.dummyApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class dummyAPIStep {

    dummyApi dummyApipage = new dummyApi();
        private String respondBody;
        private Response response;

        @Given("setting endpoint {string}")
        public void settingEndpoint(String endpoint) {
            dummyApipage.setEndpoint(endpoint);
        }
        @When("method get")
        public void methodGet() {
            response = dummyApipage.getResponse();
            System.out.println(response.getBody().asString());
        }
        @Then("status {int}")
        public void verifycode(int expectrespondCode){
            int actualrespondCode = response.getStatusCode();
            System.out.println("Actual respond code : " + actualrespondCode);
            Assert.assertEquals(expectrespondCode, actualrespondCode);
        }
        @Then("match response contains {string}")
        public void matchContains(String expectedResult) {
            respondBody = response.getBody().asString();
            Assert.assertTrue(respondBody.contains(expectedResult));
        }
}
