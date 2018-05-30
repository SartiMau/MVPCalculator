package com.maurosarti.mvpcalculator.mvp.presenter;


import android.app.Activity;

import com.maurosarti.mvpcalculator.mvp.model.CalculatorModel;
import com.maurosarti.mvpcalculator.mvp.view.CalculatorView;
import com.maurosarti.mvpcalculator.util.bus.RxBus;
import com.maurosarti.mvpcalculator.util.bus.observers.CalculatorButtonPressedBusObserver;
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

        String firstNumber = model.parseFirstNumber(account);
        String operator = account.substring(firstNumber.length(), firstNumber.length()+1);
        String secondNumber = account.substring(firstNumber.length()+1);

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

        if(subString.isEmpty()){
            view.disableOperators();
            view.disableBtnBorrar();
        } else {
            view.enableBtnBorrar();
        }
    }

    public void onCalculatorButtonPressed(String digit){
        view.setAccount(view.getAccount() + digit);
        if(model.isOperand(digit.charAt(0))){
            view.disableOperators();
        }
        view.enableBtnBorrar();
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }

        RxBus.subscribe(activity, new CalculatorButtonPressedBusObserver() {
            @Override
            public void onEvent(CalculatorButtonPressedBusObserver.CalculatorButtonPressed value) {
                onCalculatorButtonPressed(value.getDigit());
            }
        });
    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }
        RxBus.clear(activity);
    }
}
