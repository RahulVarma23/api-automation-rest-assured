package standalonescripts;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RelaxedHttpsValidations {

    @Test
    public void bypassCertErrors() {
        RestAssured.given().relaxedHTTPSValidation().when()
                .get("https://self-signed.badssl.com/")
                .then()
                .statusCode(200);
    }
}
