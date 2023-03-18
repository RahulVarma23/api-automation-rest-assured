package employeemanagement;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.practice.api.common.BaseRequest;
import org.practice.api.common.ResponseValidationSteps;
import org.practice.api.config.RequestPath;
import org.practice.api.config.RequestSpec;
import org.practice.api.dto.model.EmployeeDto;
import org.practice.api.dto.response.EmployeeResponseDto;
import org.practice.staticdata.Messages;
import org.testng.annotations.Test;


public class SendUpdateEmployee extends BaseRequest {

    @Test
    public void shouldUpdateEmployeeDetails() {
        RequestSpecification requestSpec = RequestSpec.buildEmployeeCommonSpec()
                .basePath(RequestPath.UPDATE_BY_ID.getPath())
                .pathParams("id",1);

        EmployeeDto employeeDto=  EmployeeDto.defaultEmployeeBuilder().name("test1").salary(456).build();

        Response response = sendPutRequest(requestSpec,employeeDto);

        ResponseValidationSteps.validateResponseCode(response, HttpStatus.SC_OK);

        EmployeeResponseDto updateEmployeeResponseDto = response.as(EmployeeResponseDto.class);
        Assertions.assertThat(updateEmployeeResponseDto.getStatus()).isEqualTo("success");
        Assertions.assertThat(updateEmployeeResponseDto.getMessage()).isEqualTo(Messages.SUCCESSFULLY_RECORD_HAS_BEEN_UPDATED);
    }
}
