package com.calculator;

import com.calculator.exception.DivisionByZeroException;
import com.calculator.exception.IncorrectInputException;
import com.calculator.exception.NotEnoughOperatorsException;
import com.calculator.menu.CalculatorMenu;
import com.calculator.operations.*;

import java.io.IOException;

public class Calculator {

    public static void main(String[] args) {
        CalculatorMenu calculatorMenu = new CalculatorMenu();
        calculatorMenu.displayMenu();
    }

    public static float executeOperation(int firstNumber, int secondNumber, String operator) throws DivisionByZeroException {
        float result = 0;
        Operation operation;

        switch (operator) {
            case "+":
                operation = new Addition();
                result = operation.calculate(firstNumber, secondNumber);
                break;
            case "-":
                operation = new Substraction();
                result = operation.calculate(firstNumber, secondNumber);
                break;
            case "*":
                operation = new Multiplication();
                result = operation.calculate(firstNumber, secondNumber);
                break;
            case "/":
                operation = new Division();
                result = operation.calculate(firstNumber, secondNumber);
                break;
        }
        return result;
    }

}