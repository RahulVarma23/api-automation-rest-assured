package org.practice.api.common;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class ResponseValidationSteps {

    public static void validateResponseCode(Response response, int expectedStatusCode) {
        Assertions.assertThat(response.getStatusCode()).as("Status code is not '%s'",expectedStatusCode).isEqualTo(expectedStatusCode);
    }

    public static void validateJsonSchema(Response response, String pathToSchema) {
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(pathToSchema));
    }
}
