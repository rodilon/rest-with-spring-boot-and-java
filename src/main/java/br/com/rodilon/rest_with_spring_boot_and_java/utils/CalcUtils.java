package br.com.rodilon.rest_with_spring_boot_and_java.utils;

public class CalcUtils {

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        // BR 10,25  US 10.25
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("^[1-9]\\d*(\\.\\d+)?$");
    }
}
