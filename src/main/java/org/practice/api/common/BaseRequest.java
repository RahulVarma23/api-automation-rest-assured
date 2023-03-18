package org.practice.api.common;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseRequest {

    protected Response sendGetRequest(RequestSpecification requestSpecification) {
        return given().spec(requestSpecification).log().all().when().get().then().log().all().extract().response();
    }

    protected Response sendPostRequest (RequestSpecification requestSpecification, Object body) {
        return given().spec(requestSpecification).log().all().when().body(body).post().then().log().all().extract().response();
    }

    protected Response sendPutRequest (RequestSpecification requestSpecification, Object body)  {
        return given().spec(requestSpecification).log().all().when().body(body).put().then().log().all().extract().response();
    }

    protected Response sendDeleteRequest (RequestSpecification requestSpecification)  {
        return given().spec(requestSpecification).log().all().when().delete().then().log().all().extract().response();
    }
}
