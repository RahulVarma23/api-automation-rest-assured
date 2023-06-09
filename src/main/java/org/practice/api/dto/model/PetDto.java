package org.practice.api.dto.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import static org.practice.api.utils.RandomUtils.generateIntValue;
import static org.practice.api.utils.RandomUtils.generateStringValue;

@Data
@Builder()
public class PetDto {

    int id;
    String status;
    String name;
    CategoryDto category;
    List<String> photoUrls;
    List<TagDto> tags;

    @Builder
    public static PetDtoBuilder defaultPetBuilder() {
        return new PetDtoBuilder()
                .id(generateIntValue(6))
                .category(CategoryDto.defaultCategoryBuilder().build())
                .name(generateStringValue(5))
                .photoUrls(List.of("www.google.com", "www.yahoo.com"))
                .tags(List.of(TagDto.defaultCategoryBuilder().build()))
                .status("available");
    }



}

