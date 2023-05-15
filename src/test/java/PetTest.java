import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetTest extends BaseTest {

    @Test
    public void shouldGetPetById() {
        RequestSpecification requestGet = RestAssured.given();
        Response response = requestGet.get("/pet/1");

        response
                .then()
                .statusCode(200)
                .body("name",equalTo("doggie"));
    }

    @Test
    public void shouldGetPetByIdWithTypeRef() {
        RequestSpecification requestGet = RestAssured.given();

        PetDto response = requestGet
                .get("/pet/1")
                .as(new TypeRef<>() {});

        assertThat(response.getName()).isEqualTo("doggie");

        assertThat(response)
                .extracting(
                        PetDto::getId,
                        PetDto::getStatus
                ).containsExactly(
                        1,
                       "available"
                );

    }
}
