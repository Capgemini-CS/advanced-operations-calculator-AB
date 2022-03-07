package com.calculator.operations;

import org.tinylog.Logger;

public class Multiplication implements Operation {

    @Override
    public float calculate(int firstNumber, int secondNumber) {
        Logger.info("Multiply {} by {}.", firstNumber, secondNumber);
        return firstNumber * secondNumber;
    }
}
