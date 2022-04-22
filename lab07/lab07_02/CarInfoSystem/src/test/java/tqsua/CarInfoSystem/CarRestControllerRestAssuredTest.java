package tqsua.CarInfoSystem;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.services.CarManagerService;
import tqsua.CarInfoSystem.controllers.CarRestController;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@WebMvcTest(CarRestController.class)
public class CarRestControllerRestAssuredTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    private Car car01;

    @BeforeEach
    public void init() {
        car01 = new Car("FORD", "Ford01");
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @Test
    @Disabled
    public void testPostCar_createCar() throws Exception {

        when(service.save(car01)).thenReturn(car01);

        RestAssuredMockMvc.given()
                .body(JsonUtil.toJson(car01))
                .contentType(ContentType.JSON)
                .when()
                .post("/api/cars")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);

        verify(service, times(1)).save(car01);

    }

    @Test
    public void givenCars_whenGetCars_thenReturnJsonArray() throws Exception {
        Car car02 = new Car("Peugeot", "peu01");
        Car car03 = new Car("Renault", "re01");

        List<Car> allCars = Arrays.asList(car01, car02, car03);

        given(service.getAllCars()).willReturn(allCars);

        RestAssuredMockMvc.given()
                .header("Content-type", "application/json")
                .when()
                .get("/api/cars")
                .then()
                .statusCode(200)
                .and()
                .body("$", hasSize(3))
                .and()
                .body("maker", hasItems(car01.getMaker(), car02.getMaker(), car03.getMaker()))
                .and()
                .body("model", hasItems(car01.getModel(), car02.getModel(), car03.getModel()));

        verify(service, times(1)).getAllCars();
    }



}
