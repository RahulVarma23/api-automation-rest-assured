package org.practice.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static String EMPLOYEE_API_BASE_URL = "https://dummy.restapiexample.com/api/v1";
    public static String HEADER_NAME = "content-type";
    public static String HEADER_VALUE = "application/json";

    public static RequestSpecification buildEmployeeCommonSpec(){
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(EMPLOYEE_API_BASE_URL)
                .addHeader(HEADER_NAME,HEADER_VALUE)
                .build();
        return requestSpec;
    }
}
