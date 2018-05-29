package com.maurosarti.mvpcalculator.mvp.model;

import android.content.res.Resources;

import com.maurosarti.mvpcalculator.R;

public class CalculatorModel {

    public String solve(int firstNumber, int secondNumber, String operator) {
        switch (operator){
            case "+":
                return String.valueOf(firstNumber + secondNumber);
            case "-":
                return String.valueOf(firstNumber - secondNumber);
            case "*":
                return String.valueOf(firstNumber * secondNumber);
            case "/":
                return String.valueOf(firstNumber / secondNumber);
            default:
                return Resources.getSystem().getString(R.string.error);
        }
    }

    public boolean isOperand(char lastDigit) {
        if(lastDigit == '+' || lastDigit == '-' || lastDigit == '*' || lastDigit == '/'){
            return true;
        }
        return false;
    }

    public String parseFirstNumber(String account) {
        for (int i=0; i<account.length();i++){
            if(isOperand(account.charAt(i))){
                return account.substring(0, i);
            }
        }
        return null;
    }
}
