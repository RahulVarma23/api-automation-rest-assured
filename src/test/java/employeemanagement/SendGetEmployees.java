package employeemanagement;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.practice.api.common.BaseRequest;
import org.practice.api.common.ResponseValidationSteps;
import org.practice.api.config.RequestPath;
import org.practice.api.config.RequestSpec;
import org.practice.api.dto.response.DataResponseDto;
import org.practice.api.dto.response.EmployeeResponseDto;
import org.practice.api.dto.response.EmployeesResponseDto;
import org.practice.staticdata.Messages;
import org.testng.annotations.Test;
import java.util.stream.Collectors;


public class SendGetEmployees extends BaseRequest {

    @Test
    public void shouldGetAllEmployees() {
        RequestSpecification requestSpec = RequestSpec.buildEmployeeCommonSpec()
                .basePath(RequestPath.EMPLOYEES.getPath());

        Response response = sendGetRequest(requestSpec);

        ResponseValidationSteps.validateResponseCode(response, HttpStatus.SC_OK);
        ResponseValidationSteps.validateJsonSchema(response, "schemas/EmployeeSchema.json" );

        EmployeesResponseDto employee = response.as(EmployeesResponseDto.class);

        Assertions.assertThat(employee.getMessage()).as("validate message").isEqualTo(Messages.SUCCESSFULLY_ALL_RECORDS_HAS_BEEN_FETCHED);
        Assertions.assertThat(employee.getStatus()).as("validate status").isEqualTo("success");
        Assertions.assertThat(employee.getData().stream().map(DataResponseDto::getEmployeeName).filter(name->name.startsWith("C")).collect(Collectors.toList())).containsExactlyInAnyOrder("Charde Marshall","Cedric Kelly","Caesar Vance","Colleen Hurst");
    }

    @Test
    public void shouldGetSingleEmployeeData() {
        RequestSpecification requestSpec = RequestSpec.buildEmployeeCommonSpec()
                .basePath(RequestPath.EMPLOYEE_BY_ID.getPath())
                .pathParam("id","1");

        Response response = sendGetRequest(requestSpec);

        ResponseValidationSteps.validateResponseCode(response, HttpStatus.SC_OK);

        EmployeeResponseDto employee = response.as(EmployeeResponseDto.class);
        Assertions.assertThat(employee.getMessage()).as("validate message").isEqualTo(Messages.SUCCESSFULLY_RECORD_HAS_BEEN_FETCHED);
        Assertions.assertThat(employee.getStatus()).as("validate status").isEqualTo("success");
        Assertions.assertThat(employee.getData()).isNotNull();
    }

    @Test
    public void shouldReturnNullDataWithInvalidId() {
        RequestSpecification requestSpec = RequestSpec.buildEmployeeCommonSpec()
                .basePath(RequestPath.EMPLOYEE_BY_ID.getPath())
                .pathParam("id","25");

        Response response = sendGetRequest(requestSpec);

        ResponseValidationSteps.validateResponseCode(response, HttpStatus.SC_OK);

        EmployeeResponseDto employee = response.as(EmployeeResponseDto.class);
        Assertions.assertThat(employee.getMessage()).as("validate message").isEqualTo(Messages.SUCCESSFULLY_RECORD_HAS_BEEN_FETCHED);
        Assertions.assertThat(employee.getStatus()).as("validate status").isEqualTo("success");
        Assertions.assertThat(employee.getData()).isNull();
    }
}
