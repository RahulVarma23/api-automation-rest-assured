package org.practice.api.dto.model;

import lombok.Builder;
import lombok.Data;
import static org.practice.api.utils.RandomUtils.*;

@Data
@Builder()
public class CategoryDto {
    int id;
    String name;

    @Builder
    public static CategoryDtoBuilder defaultCategoryBuilder() {
        return new CategoryDtoBuilder()
                .id(generateIntValue(2))
                .name(generateStringValue(5));
    }
}
