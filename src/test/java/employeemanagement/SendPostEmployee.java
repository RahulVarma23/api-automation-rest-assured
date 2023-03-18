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

public class SendPostEmployee extends BaseRequest {

    @Test
    public void shouldCreateNewEmployee() {
        EmployeeDto employeeDto=  EmployeeDto.defaultEmployeeBuilder().build();

        RequestSpecification requestSpec = RequestSpec.buildEmployeeCommonSpec()
                .basePath(RequestPath.CREATE.getPath());

        Response response = sendPostRequest(requestSpec, employeeDto);
        ResponseValidationSteps.validateResponseCode(response, HttpStatus.SC_OK);

        EmployeeResponseDto employeeResponseDto = response.as(EmployeeResponseDto.class);

        Assertions.assertThat(employeeResponseDto.getStatus()).isEqualTo("success");
        Assertions.assertThat(employeeResponseDto.getMessage()).isEqualTo(Messages.SUCCESSFULLY_RECORD_HAS_BEEN_ADDED);
        Assertions.assertThat(employeeResponseDto.getData().getName()).isEqualTo(employeeDto.getName());
    }
}
