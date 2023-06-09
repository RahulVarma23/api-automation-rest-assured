package org.practice.api.dto.model;

import lombok.Builder;
import lombok.Data;
import static org.practice.api.utils.RandomUtils.*;


@Data
@Builder()
public class EmployeeDto {
    String name;
    long age;
    long salary;

    @Builder
    public static EmployeeDtoBuilder defaultEmployeeBuilder(){
        return new EmployeeDtoBuilder()
                .age(generateIntValue(2))
                .name(generateStringValue(5))
                .salary(generateIntValue(4));
    }
}



