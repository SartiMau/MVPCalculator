package com.maurosarti.mvpcalculator.util.bus.observers;

public abstract class CalculatorButtonPressedBusObserver extends BusObserver<CalculatorButtonPressedBusObserver.CalculatorButtonPressed> {

    public CalculatorButtonPressedBusObserver() {
        super(CalculatorButtonPressed.class);
    }

    public static class CalculatorButtonPressed {

        private String digit;

        public CalculatorButtonPressed(String digit) {
            this.digit = digit;
        }

        public String getDigit(){
            return this.digit;
        }
    }
}