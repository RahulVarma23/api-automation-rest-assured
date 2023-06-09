package org.practice.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetResponseDto {
    int id ;
    String status;
    List<String> photoUrls;
    List<TagResponseDto> tags;
    CategoryResponseDto category;
    String name;

    @EqualsAndHashCode
    @ToString
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class CategoryResponseDto {
        int id;
        String name;
    }

    @EqualsAndHashCode
    @ToString
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class TagResponseDto {
        int id;
        String name;
    }

}
