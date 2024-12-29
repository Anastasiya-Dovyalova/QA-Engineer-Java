import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.containsString;

public class PostmanTest {
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    void testGetRequest() {
        given().log().all()
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then().log().body().statusCode(200)
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(""))
                .body("headers.accept-encoding", notNullValue())
                .body("headers.cookie", not(""))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }

    @Test
    void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given().log().all()
                .contentType("text/plain; charset=ISO-8859-1")
                .body(requestBody) // Отправляем тело запроса
                .when().post("/post")
                .then().log().body().statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(""))
                .body("headers.accept-encoding", notNullValue())
                .body("headers.cookie", not(""))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void testPostFromData() {
        given().log().all()
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .when().post("/post")
                .then().log().body().statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(""))
                .body("headers.accept-encoding", notNullValue())
                .body("headers.cookie", not(""))
                .body("json.foo1", equalTo("bar1")) // Проверяем, что отправленные данные в формате JSON
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));

    }

    @Test
    void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given().log().all()
                .contentType("text/plain; charset=ISO-8859-1")
                .body(requestBody) // Отправляем тело запроса
                .when().put("/put")
                .then().log().body().statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(""))
                .body("headers.accept-encoding", notNullValue())
                .body("headers.cookie", not(""))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"));

    }

    @Test
    void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given().log().all()
                .contentType("text/plain; charset=ISO-8859-1")
                .body(requestBody) // Отправляем тело запроса
                .when().patch("/patch")
                .then().log().body().statusCode(200)
                .assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(""))
                .body("headers.accept-encoding", notNullValue())
                .body("headers.cookie", not(""))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"));

    }
    @Test
    void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given().log().all()
                .contentType("text/plain; charset=ISO-8859-1")
                .body(requestBody) // Отправляем тело запроса
                .when().delete("/delete?foo1=bar1")
                .then().log().body().statusCode(200)
                .assertThat()
                .body("args.foo1", equalTo("bar1"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", not(""))
                .body("headers.accept-encoding", notNullValue())
                .body("headers.cookie", not(""))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete?foo1=bar1"));

    }
}
