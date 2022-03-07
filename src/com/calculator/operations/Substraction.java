package com.calculator.operations;

import org.tinylog.Logger;

public class Substraction implements Operation {
    @Override
    public float calculate(int firstNumber, int secondNumber) {
        Logger.info("Substract {} from {}.", firstNumber, secondNumber);
        return firstNumber - secondNumber;
    }
}
