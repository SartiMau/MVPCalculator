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
        view.setResult(model.solve(view.getMathAccount()));
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity==null){
            return;
        }

        RxBus.subscribe(activity, new ResultButtonPressedBusObserver() {
            @Override
            public void onEvent(ResultButtonPressedBusObserver.ResultButtonPressed value) {
                onResultButtonPressed();
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
