package blazedemo.stepdefinition;

import blazedemo.pages.dummyApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class dummyAPIStep {

    dummyApi dummyApipage = new dummyApi();
        private String respondBody;
        private Response response;
        private static String createdUserId;

        @Given("setting endpoint {string}")
        public void settingEndpoint(String endpoint) {
            dummyApipage.setEndpoint(endpoint);
        }

        @Given("setting post endpoint {string}")
        public void postsettingEndpoint(String endpoint) {
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
            Assert.assertTrue("unexpected status code: " + actualrespondCode, actualrespondCode == 200 || actualrespondCode == 201);
        }
        @Then("match response contains {string}")
        public void matchContains(String expectedResult) {
            respondBody = response.getBody().asString();
            Assert.assertTrue(respondBody.contains(expectedResult));
        }

        @When("method get specific user ID")
        public void methodGetSpecificUserID() {
            response = dummyApipage.IDResponse();
            System.out.println(response.getBody().asString());
        }

        @When("method get specific user ID without appId")
        public void methodGetSpecificUserIDFalse() {
            response = dummyApipage.IDResponsewithoutID();
            System.out.println(response.getBody().asString());
        }

        @Given("the Request body:")
        public void theRequestBody(String requestBody) {
            this.respondBody = requestBody;
        }

        @When("user send post request")
        public void usersendPostRequest() {
            response = dummyApi.sendPostRequest(respondBody);

            if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
                createdUserId = response.jsonPath().getString("id");
                System.out.println("Extracted User ID: " + createdUserId);
            } else {
                //buat debug
                System.out.println("User creation failed. Response: " + response.getBody().asString());
            }

            //buat Debugg
            System.out.println("Response Body: " + response.getBody().asString());
            System.out.println("Status Code: " + response.getStatusCode());
        }

    @Given("setting put endpoint {string}")
    public void settingPutEndpoint(String endpoint) {
        if (createdUserId != null) {
            String updatedEndpoint = endpoint.replace("{createdUserId}", createdUserId);
            dummyApipage.setEndpoint(updatedEndpoint);
        } else {
            System.out.println("No valid user ID");
        }
    }
    @When("user send put request")
    public void userSendPutRequest() {
        if (createdUserId != null) {
            response = dummyApi.updateUser(createdUserId, respondBody);
        } else {
            //buat debugg
            System.out.println("No valid user ID");
        }
    }

    @Given("setting delete endpoint {string}")
    public void settingDeleteEndPoint(String endpoint) {
        if (createdUserId != null) {
            String updatedEndpoint = endpoint.replace("{createdUserId}", createdUserId);
            dummyApipage.setEndpoint(updatedEndpoint);
        } else {
            System.out.println("No valid user ID");
        }
    }

    @When("user send delete request")
    public void userSendDeleteRequest() {
            if (createdUserId != null) {
                //buat Debugg
                System.out.println("Final PUT Endpoint: " + RestAssured.baseURI);
                response = dummyApi.deleteUser(createdUserId);
            }else {
                System.out.println("No valid user ID");
            }
    }
}
