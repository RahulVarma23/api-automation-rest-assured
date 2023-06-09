package petmanagement;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.practice.api.common.BaseRequest;
import org.practice.api.common.ResponseValidationSteps;
import org.practice.api.config.RequestPath;
import org.practice.api.config.RequestSpec;
import org.practice.api.dto.model.PetDto;
import org.practice.api.dto.response.PetResponseDto;
import org.testng.annotations.Test;

public class AddPetApiTest extends BaseRequest {

    @Test
    public void shouldAddNewPet() {
        PetDto petDto = PetDto.defaultPetBuilder().build();

        RequestSpecification requestSpecification = RequestSpec.buildPetCommonSpec()
                .basePath(RequestPath.PET.getPath());

        Response addPetResponse = sendPostRequest(requestSpecification, petDto);
        ResponseValidationSteps.validateResponseCode(addPetResponse, HttpStatus.SC_OK);

        PetResponseDto petResponseDto = addPetResponse.as(PetResponseDto.class);

        Assertions.assertThat(petResponseDto.getId()).isEqualTo(petDto.getId());
        Assertions.assertThat(petResponseDto.getName()).isEqualTo(petDto.getName());
        Assertions.assertThat(petResponseDto.getPhotoUrls()).containsExactlyInAnyOrderElementsOf(petDto.getPhotoUrls());

        RequestSpecification getRequestSpecification = RequestSpec.buildPetCommonSpec()
                .basePath(RequestPath.PET_PET_ID.getPath()).pathParam("petId",petDto.getId());

        Response getPetResponse = sendGetRequest(getRequestSpecification);
        ResponseValidationSteps.validateResponseCode(getPetResponse, HttpStatus.SC_OK);

        Response deletePetResponse = sendDeleteRequest(getRequestSpecification);
        ResponseValidationSteps.validateResponseCode(deletePetResponse, HttpStatus.SC_OK);

        Response getPetResponse1 = sendDeleteRequest(getRequestSpecification);
        ResponseValidationSteps.validateResponseCode(getPetResponse1, HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void shouldAddNewPetAndValidateJsonSchema() {
        PetDto petDto = PetDto.defaultPetBuilder().build();

        RequestSpecification requestSpecification = RequestSpec.buildPetCommonSpec()
                .basePath(RequestPath.PET.getPath());

        Response addPetResponse = sendPostRequest(requestSpecification, petDto);
        ResponseValidationSteps.validateResponseCode(addPetResponse, HttpStatus.SC_OK);
        ResponseValidationSteps.validateJsonSchema(addPetResponse, "schemas/AddPetSchema.json");

        PetResponseDto petResponseDto = addPetResponse.as(PetResponseDto.class);

        Assertions.assertThat(petResponseDto.getId()).isEqualTo(petDto.getId());
        Assertions.assertThat(petResponseDto.getName()).isEqualTo(petDto.getName());
        Assertions.assertThat(petResponseDto.getPhotoUrls()).containsExactlyInAnyOrderElementsOf(petDto.getPhotoUrls());
    }
}
