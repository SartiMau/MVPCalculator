package com.maurosarti.mvpcalculator.util;

public class Utils {

    public static boolean isOperand(char lastDigit) {
        if(lastDigit == '+' || lastDigit == '-' || lastDigit == '*' || lastDigit == '/'){
            return true;
        }
        return false;
    }
}
