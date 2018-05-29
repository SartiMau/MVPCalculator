package com.maurosarti.mvpcalculator.util.bus.observers;

public abstract class ResultButtonPressedBusObserver extends BusObserver<ResultButtonPressedBusObserver.ResultButtonPressed> {

    public ResultButtonPressedBusObserver() {
        super(ResultButtonPressed.class);
    }

    public static class ResultButtonPressed {

        public String account;

        public ResultButtonPressed(String account) {
            this.account = account;
        }
    }
}