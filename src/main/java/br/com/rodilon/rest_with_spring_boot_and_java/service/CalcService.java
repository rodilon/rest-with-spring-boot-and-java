package br.com.rodilon.rest_with_spring_boot_and_java.service;

import br.com.rodilon.rest_with_spring_boot_and_java.exceptions.CalcException;
import br.com.rodilon.rest_with_spring_boot_and_java.utils.CalcUtils;

public class CalcService {

    private final CalcUtils calcUtils;
    private final CalcException calcException;

    public CalcService(CalcUtils calcUtils, CalcException calcException) {
        this.calcUtils = calcUtils;
        this.calcException = calcException;
    }

    public Double sum(String numberOne, String numberTwo) throws IllegalArgumentException {
        double num1 = validateAndConvert(numberOne);
        double num2 = validateAndConvert(numberTwo);
        return num1 + num2;
    }

    public Double sub(String numberOne, String numberTwo) throws IllegalArgumentException {
        double num1 = validateAndConvert(numberOne);
        double num2 = validateAndConvert(numberTwo);
        return num1 - num2;
    }

    public Double multiply(String numberOne, String numberTwo) throws IllegalArgumentException {
        double num1 = validateAndConvert(numberOne);
        double num2 = validateAndConvert(numberTwo);
        return num1 * num2;
    }

    public Double div(String numberOne, String numberTwo) throws IllegalArgumentException, ArithmeticException {
        double num1 = validateAndConvert(numberOne);
        double num2 = validateAndConvert(numberTwo);

        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return num1 / num2;
    }

    public Double med(String numberOne, String numberTwo) throws IllegalArgumentException {
        double num1 = validateAndConvert(numberOne);
        double num2 = validateAndConvert(numberTwo);
        return (num1 + num2) / 2;
    }

    public Double squareRoot(String numberOne) throws IllegalArgumentException {
        double num = validateAndConvert(numberOne);

        if (num < 0) {
            throw new IllegalArgumentException("Square root of a negative number is not allowed.");
        }

        return Math.sqrt(num);
    }

    private double validateAndConvert(String number) throws IllegalArgumentException {
        calcException.validateInput(number);
        return calcUtils.convertToDouble(number);
    }
}
