package com.calculator.input;

import com.calculator.exception.IncorrectInputException;
import com.calculator.input.validation.InputValidation;
import org.tinylog.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InputValuesFile implements InputValuesInterface {
    public static final String INPUT_FILE_PATH = "InputEquationValue.txt";

    @Override
    public int getInputValueFirstNumber() throws IncorrectInputException {
        int firstNumber = 0;
        try {
            firstNumber = extractNumberFromStringAtIndex(0, 0);
        } catch (IOException e) {
            Logger.error("Incorrect input");
            throw new IncorrectInputException("Incorrect input.");
        }
        return firstNumber;
    }

    @Override
    public int getInputValueSecondNumber() throws IncorrectInputException {
        int secondNumber = 0;
        try {
            secondNumber = extractNumberFromStringAtIndex(0, 1);
        } catch (IOException e) {
            Logger.error("Incorrect input");
            throw new IncorrectInputException("Incorrect input.");
        }
        return secondNumber;
    }

    @Override
    public String getInputValueOperator() throws IncorrectInputException {
        String operator = null;
        try {
            operator = extractStringAtIndex(0, 2);
        } catch (IOException e) {
            Logger.error("Incorrect input");
            throw new IncorrectInputException("Incorrect input.");
        }
        return operator;
    }

    private int extractNumberFromStringAtIndex(int lineIndex, int stringIndex) throws IOException {
        return InputValidation.stringToNumericValue(splitLineAtIndexByComma(lineIndex).get(stringIndex));
    }

    private ArrayList<String> splitLineAtIndexByComma(int lineIndex) throws IOException {
        InputValuesFile inputValuesFile = new InputValuesFile();
        ArrayList<String> inputFileLines = inputValuesFile.getInputFromFileLineByLine(INPUT_FILE_PATH);
        return new ArrayList<>(Arrays.asList(inputFileLines.get(lineIndex).split(",")));
    }

    private String extractStringAtIndex(int lineIndex, int stringIndex) throws IOException {
        return splitLineAtIndexByComma(lineIndex).get(stringIndex);
    }

    private ArrayList<String> getInputFromFileLineByLine(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = null;
        String line;
        ArrayList<String> inputFileLines = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                inputFileLines.add(line);
            }
        } catch (IOException e) {
            Logger.error("Incorrect input");
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return inputFileLines;
    }


}
