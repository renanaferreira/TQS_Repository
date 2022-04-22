package org.example.exc01;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class restAssuredTest {

    private final String API_URL = "https://jsonplaceholder.typicode.com/todos";

    @Test
    public void endpointIsAvailableTest() {
        when()
                .get(API_URL)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void whenReq4_getTodo() {
        when()
                .get(API_URL+"/4")
                .then()
                .assertThat()
                .body("title", equalTo("et porro tempora"));
    }

    @Test
    public void whenReq_get198e199() {
        when()
                .get(API_URL)
                .then()
                .assertThat()
                .body("id", hasItems(198, 199));
    }
}
