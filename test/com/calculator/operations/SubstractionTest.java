package com.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstractionTest {

    Substraction substraction = new Substraction();

    @Test
    void executeSubstraction() {
        assertEquals(2, substraction.calculate(8,6));
    }

}