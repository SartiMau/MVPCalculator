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
}
