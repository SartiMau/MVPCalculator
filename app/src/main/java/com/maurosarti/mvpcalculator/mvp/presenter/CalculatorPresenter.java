package com.maurosarti.mvpcalculator.mvp.presenter;

import android.app.Activity;

import com.maurosarti.mvpcalculator.mvp.model.CalculatorModel;
import com.maurosarti.mvpcalculator.mvp.view.CalculatorView;
import com.maurosarti.mvpcalculator.util.bus.RxBus;
import com.maurosarti.mvpcalculator.util.bus.observers.ResultButtonPressedBusObserver;

public class CalculatorPresenter {

    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel calculatorModel, CalculatorView calculatorView) {
        this.model = calculatorModel;
        this.view = calculatorView;
    }

    public void onResultButtonPressed(){
        String account = view.getAccount();

        String firstNumber;
        String secondNumber;
        String operator;

        firstNumber = model.parseFirstNumber(account);
        operator = account.substring(firstNumber.length(), firstNumber.length()+1);
        secondNumber = account.substring(firstNumber.length()+1);

        view.setResult(model.solve(Integer.valueOf(firstNumber), Integer.valueOf(secondNumber), operator));
    }

    public void enableOperators() {
        view.enableOperators();
    }

    public void removeLastDigit() {
        String account = view.getAccount();

        String subString = account.substring(0, account.length()-1);
        char lastDigit = account.charAt(account.length()-1);

        view.setAccount(subString);

        if (model.isOperand(lastDigit)){
            enableOperators();
        }

        if(account.isEmpty()){
            view.disableBtnBorrar();
        } else {
            view.enableBtnBorrar();
        }
    }
}
