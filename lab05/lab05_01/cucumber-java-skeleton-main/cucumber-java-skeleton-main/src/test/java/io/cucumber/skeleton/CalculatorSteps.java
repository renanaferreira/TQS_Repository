package io.cucumber.skeleton;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {

    private Calculator calculator;

    @Given("a calculator I just turned on")
    public void setup() {
        calculator = new Calculator();
    }

    @When("I add (int) and (int)")
    public void i_add_and(Integer int1, Integer int2) {
        calculator.push(int1);
        calculator.push(int2);
        calculator.push("+");
    }

    @When("I substract {int} to {int}")
    public void substract(int arg1, int arg2) {
        calculator.push(arg1);
        calculator.push(arg2);
        calculator.push("-");
    }

    @Then("the result is {int}")
    public void the_result_is(double expected) {
        Number value = calculator.value();
        assertEquals(expected, value);
    }

}
