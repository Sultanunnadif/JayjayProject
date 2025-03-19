package blazedemo.pages;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class dummyApi {
    private String baseURI = "https://dummyapi.io/data/v1/";
    private static Response response;

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
    public Response IDResponse(){
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get("60d0fe4f5311236168a109cd")
                .then()
                .extract()
                .response();

        return response;
    }
    public static Response sendPostRequest(String requestBody){
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract()
                .response();
        return response;
    }
    public static Response updateUser(String userId, String requestBody) {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put()
                .then()
                .extract()
                .response();
        return response;
    }
}
