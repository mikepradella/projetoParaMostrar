import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuarioApiTest {

    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // ou sua API real
    }

    @Test
    public void criarUsuario() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"mike\", \"email\": \"mike@example.com\" }")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("mike"));
    }

    @Test
    public void consultarUsuario() {
        when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    public void atualizarUsuario() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"mike Atualizada\" }")
                .when()
                .put("/users/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("mike Atualizada"));
    }

    @Test
    public void deletarUsuario() {
        when()
                .delete("/users/1")
                .then()
                .statusCode(anyOf(is(200), is(204)));
    }
}