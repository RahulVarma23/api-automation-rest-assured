package org.practice.api.dto.model;

import lombok.Builder;
import lombok.Data;

import static org.practice.api.utils.RandomUtils.generateIntValue;
import static org.practice.api.utils.RandomUtils.generateStringValue;

@Data
@Builder()
public class TagDto {
    int id;
    String name;

    @Builder
    public static TagDtoBuilder defaultCategoryBuilder() {
        return new TagDtoBuilder()
                .id(generateIntValue(2))
                .name(generateStringValue(5));
    }
}
