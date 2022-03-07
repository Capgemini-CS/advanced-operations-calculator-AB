package com.calculator.input;

import com.calculator.exception.IncorrectInputException;
import com.calculator.input.validation.InputValidation;
import org.tinylog.Logger;

import java.util.Scanner;

public class InputValuesConsole implements InputValuesInterface {
    static Scanner scanner = new Scanner(System.in);
    private int firstNumber;
    private int secondNumber;
    private String operator;

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
            Logger.error("Incorrect input operator.");
        }
        return this.operator;
    }
}
