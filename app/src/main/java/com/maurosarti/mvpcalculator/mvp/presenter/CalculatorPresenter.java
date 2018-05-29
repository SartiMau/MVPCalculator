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

    public void onResultButtonPressed(String account){
        String firstNumber;
        String secondNumber;
        String operator;

        firstNumber = parseFirstNumber(account);
        operator = account.substring(firstNumber.length(), firstNumber.length()+1);
        secondNumber = account.substring(firstNumber.length()+1);

        view.setResult(model.solve(Integer.valueOf(firstNumber), Integer.valueOf(secondNumber), operator));
    }

    private String parseFirstNumber(String account) {
        for (int i=0; i<account.length();i++){
            if(CalculatorModel.isOperand(account.charAt(i))){
                return account.substring(0, i);
            }
        }
        return null;
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }

        RxBus.subscribe(activity, new ResultButtonPressedBusObserver() {
            @Override
            public void onEvent(ResultButtonPressedBusObserver.ResultButtonPressed value) {
                onResultButtonPressed(value.account);
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
