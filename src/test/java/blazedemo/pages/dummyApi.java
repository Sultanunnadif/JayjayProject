package blazedemo.pages;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class dummyApi {
    private String baseURI = "https://dummyapi.io/data/v1/";
    private Response response;

    public void setEndpoint (String endpoint) {
        RestAssured.baseURI = baseURI + endpoint;
    }
    public Response getResponse() {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a") // Replace with actual app-id
                .when()
                .get()
                .then()
                .extract()
                .response();

        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getBodyResponse() {
        return response.getBody().asString();
    }

}
