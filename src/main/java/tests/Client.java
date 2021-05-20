package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestEntity.User;

import static io.restassured.RestAssured.*;

public class Client {

    private final RequestSpecBuilder reqBuilder;
    private final RequestSpecification reqSpec;

    public Client() {
        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri("https://reqres.in");
        reqBuilder.setBasePath("/api/users/");
        reqSpec = reqBuilder.build();
    }

    public Response createUserResponse(User requestBody) {
        return given(reqSpec).contentType(ContentType.JSON).body(requestBody).
                when().post().
                then().log().all().extract().response();
    }

    public Response updateUserResponse(User requestBody) {
        return given(reqSpec).contentType(ContentType.JSON).body(requestBody).when().put().then().log().all().extract().response();
    }

    public Response getUserResponse(User requestBody) {
        return given(reqSpec).contentType(ContentType.JSON).pathParam("userId", requestBody.getId()).when().get("{userId}").then().log().all().extract().response();
    }

    public Response deleteUserResponse(User requestBody) {
        return given(reqSpec).contentType(ContentType.JSON).pathParam("userId", requestBody.getId()).when().get("{userId}").then().log().all().extract().response();
    }


}
