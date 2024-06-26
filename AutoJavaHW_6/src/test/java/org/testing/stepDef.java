package org.testing;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class stepDef {

    private int num1;
    private int num2;
    private int result;

    @Given("I have two numbers {int} and {int}")
    public void i_have_two_numbers_and(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @When("I add them")
    public void i_add_them() {
        result = num1 + num2;
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }
}

