package com.calculator.input;

import com.calculator.exception.IncorrectInputException;
import com.calculator.input.validation.InputValidation;

import java.util.Scanner;

public class InputValuesConsole implements InputValuesInterface {
    static Scanner scanner = new Scanner(System.in);
    int firstNumber;
    int secondNumber;
    String operator;

    @Override
    public int getInputValueFirstNumber()  {
        this.firstNumber =  scanner.nextInt();
        return this.firstNumber;
    }

    @Override
    public int getInputValueSecondNumber() {
        this.secondNumber = scanner.nextInt();
        return this.secondNumber;
    }

    @Override
    public String getInputValueOperator() {
        this.operator = scanner.next();
        try {
            if (!InputValidation.valueIsOneOfTheOperators(operator)) {
                return null;
            }
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        return this.operator;
    }
}
