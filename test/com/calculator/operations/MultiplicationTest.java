package com.calculator.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplicationTest {
    Multiplication multiplication = new Multiplication();

    @Test
    void executeMultiplication() {
        assertEquals(2, multiplication.calculate(2,1));
    }
}