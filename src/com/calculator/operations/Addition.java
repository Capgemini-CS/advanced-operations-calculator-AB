package com.calculator.operations;

import org.tinylog.Logger;

public class Addition implements Operation {
    @Override
    public float calculate(int firstNumber, int secondNumber) {
        Logger.info("Add {} and {}.", firstNumber, secondNumber);
        return firstNumber + secondNumber;
    }
}
