package org.practice.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponseDto {
    int id;
    @JsonProperty("employee_name")
    String employeeName;
    @JsonProperty("employee_salary")
    int employeeSalary;
    @JsonProperty("employee_age")
    int employeeAge;
    @JsonProperty("profile_image")
    String profileImage;
    String name;
    int age, salary;
}
