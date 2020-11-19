package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    public static final String token = System.getenv()
            .getOrDefault("token", PropertyReader.getProperty("token"));
    public static final String url = System.getenv()
            .getOrDefault("url", PropertyReader.getProperty("url"));
    Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    /**
     *
     * @param uri e.g. v1/project (will be concatenated with URL
     * @return body
     */

    public String get(String uri) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                .when()
                        .get(url + uri)
                .then()
                        .log().all()
                        .extract().body().asString();
    }

    /**
     *
     * @param uri e.g. v1/project (will be concatenated with URL
     * @param body request body
     * @return whole body of the response. Usually contains status and ID of the object
     */
    public Response post(String uri, String body) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .post(url + uri)
                .then()
                        .log().all()
                        .extract().response();
    }

    public void delete(String uri) {
        given()
                .header("Token", token)
                .header("Content-Type", "application/json")
        .when()
                .delete(url + uri)
        .then()
                .log().all();
    }

    /**
     *
     * @param uri e.g. v1/project (will be concatenated with URL
     * @param body request body
     * @return whole body of the response. Usually contains status and ID of the object
     */
    public Response patch(String uri, String body) {
        return
                given()
                        .header("Token", token)
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .patch(url + uri)
                .then()
                        .log().all()
                        .extract().response();
    }
}
