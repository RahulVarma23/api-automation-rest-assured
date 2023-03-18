package employeemanagement;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.practice.api.common.BaseRequest;
import org.practice.api.common.ResponseValidationSteps;
import org.practice.api.config.RequestPath;
import org.practice.api.config.RequestSpec;
import org.testng.annotations.Test;

public class SendDeleteEmployee extends BaseRequest {

    @Test
    public void shouldDeleteEmployee() {
        RequestSpecification requestSpecification = RequestSpec.buildEmployeeCommonSpec()
                .basePath(RequestPath.TEST.getPath())
                .pathParams("id","2");

        Response response = sendDeleteRequest(requestSpecification);
        ResponseValidationSteps.validateResponseCode(response, HttpStatus.SC_OK);
    }
}
