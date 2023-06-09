package org.practice.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static final String EMPLOYEE_API_BASE_URL = "https://dummy.restapiexample.com/api/v1";
    public static final String PET_API_BASE_URL = "https://petstore.swagger.io/v2/";
    public static final String HEADER_NAME = "content-type";
    public static final String HEADER_VALUE = "application/json";

    public static RequestSpecification buildEmployeeCommonSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(EMPLOYEE_API_BASE_URL)
                .addHeader(HEADER_NAME,HEADER_VALUE)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification buildPetCommonSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(PET_API_BASE_URL)
                .addHeader(HEADER_NAME,HEADER_VALUE)
                .setContentType(ContentType.JSON)
                .build();
    }
}
