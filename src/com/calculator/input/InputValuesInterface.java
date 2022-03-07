package com.calculator.input;

import com.calculator.exception.IncorrectInputException;

public interface InputValuesInterface {

    int getInputValueFirstNumber() throws IncorrectInputException;
    int getInputValueSecondNumber() throws IncorrectInputException;
    String getInputValueOperator() throws IncorrectInputException;

}
