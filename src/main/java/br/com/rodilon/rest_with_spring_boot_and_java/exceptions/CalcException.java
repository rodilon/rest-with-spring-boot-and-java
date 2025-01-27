package br.com.rodilon.rest_with_spring_boot_and_java.exceptions;

import br.com.rodilon.rest_with_spring_boot_and_java.utils.CalcUtils;

public class CalcException {

    final CalcUtils calcUtils;

    public CalcException(CalcUtils calcUtils){
        this.calcUtils = calcUtils;
    }

    public void validateInput(String numberOne) {
        if (!calcUtils.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
    }
}
