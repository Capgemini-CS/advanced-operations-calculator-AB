package com.calculator.operations;

import com.calculator.exception.DivisionByZeroException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    Division division = new Division();

    @Test
    void executeDivision() throws DivisionByZeroException {
        assertEquals(2, division.calculate(8,4));
    }
}