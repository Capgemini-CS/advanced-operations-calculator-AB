package com.calculator.menu;

import com.calculator.Calculator;
import com.calculator.exception.DivisionByZeroException;
import com.calculator.exception.IncorrectInputException;
import com.calculator.exception.NotEnoughOperatorsException;
import com.calculator.input.InputValuesConsole;
import com.calculator.input.InputValuesFile;
import com.calculator.output.ShowOutputOnConsole;
import com.calculator.output.ShowOutputOnFile;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorMenu implements CalculatorMenuInterface {

    @Override
    public void displayMenu() {
        try {
            chooseOutputMethod(equationResultForChosenInputMethod());
        } catch (IncorrectInputException | DivisionByZeroException | NotEnoughOperatorsException | IOException e) {
            Logger.error(e);
        }
    }

    private float equationResultForChosenInputMethod() throws IncorrectInputException, DivisionByZeroException, NotEnoughOperatorsException, IOException {
        float equationResult = 0;
        System.out.println("Choose input method: ");
        Scanner inputMethod = new Scanner(System.in);
        String methodType = inputMethod.nextLine();

        switch (methodType) {
            case "CONSOLE":
                System.out.println("Insert input data(number, number, math operator):");

                InputValuesConsole inputValuesConsole = new InputValuesConsole();
                equationResult = Calculator.executeOperation(
                        inputValuesConsole.getInputValueFirstNumber(),
                        inputValuesConsole.getInputValueSecondNumber(),
                        inputValuesConsole.getInputValueOperator());
                break;
            case "FILE":
                InputValuesFile inputValuesFile = new InputValuesFile();
                equationResult = Calculator.executeOperation(
                        inputValuesFile.getInputValueFirstNumber(),
                        inputValuesFile.getInputValueSecondNumber(),
                        inputValuesFile.getInputValueOperator());
                break;

        }
        return equationResult;
    }

    private void chooseOutputMethod(float equationResult) {
        System.out.println("Choose output method: ");
        Scanner inputMethod = new Scanner(System.in);

        switch (inputMethod.nextLine()) {
            case "CONSOLE":
                ShowOutputOnConsole showOutputOnConsole = new ShowOutputOnConsole();
                showOutputOnConsole.showOutput(equationResult);
                break;
            case "FILE":
                ShowOutputOnFile showOutputOnFile = new ShowOutputOnFile();
                showOutputOnFile.showOutput(equationResult);
        }
    }
}
