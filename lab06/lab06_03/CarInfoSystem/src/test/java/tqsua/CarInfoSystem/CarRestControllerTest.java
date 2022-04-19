package tqsua.CarInfoSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import tqsua.CarInfoSystem.controllers.CarRestController;
import tqsua.CarInfoSystem.entities.Car;
import tqsua.CarInfoSystem.services.CarManagerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.String.valueOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarRestController.class)
public class CarRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    private Car car01;

    @BeforeEach
    public void setUp() {
        car01 = new Car("FORD", "Ford01");
    }

    @Test
    public void testPostCar_createCar() throws Exception {
        when(service.save(Mockito.any())).thenReturn(car01);

        System.out.printf("car01-1: %s\n", car01.getMaker());

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(car01)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is(car01.getMaker())));

        verify(service, times(1)).save(Mockito.any());
    }

    @Test
    public void givenCars_whenGetCars_thenReturnJsonArray() throws Exception {
        Car car02 = new Car("Peugeot", "peu01");
        Car car03 = new Car("Renault", "re01");

        List<Car> allCars = Arrays.asList(car01, car02, car03);

        given(service.getAllCars()).willReturn(allCars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
                .andExpect( jsonPath("$[0].maker", is(car01.getMaker())))
                .andExpect( jsonPath("$[1].maker", is(car02.getMaker())))
                .andExpect( jsonPath("$[2].maker", is(car03.getMaker())));

        verify(service, VerificationModeFactory.times(1)).getAllCars();

    }

    @Test
    @Disabled
    public void getCarNotExisted() throws Exception {
        long notExistedCarId = -99L;

        given(service.getCarDetails(notExistedCarId)).willReturn(null);
        String url = "/api/cars/" + valueOf(notExistedCarId);

        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(service, VerificationModeFactory.times(1)).getCarDetails(notExistedCarId);
    }

    @Test
    public void getCarExisted() throws Exception {
        long id = 1L;

        given(service.getCarDetails(id)).willReturn(Optional.of(car01));

        String url = "/api/cars/" + valueOf(id);
        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maker", is(car01.getMaker())));

        verify(service, VerificationModeFactory.times(1)).getCarDetails(id);
    }

}
