package com.maurosarti.mvpcalculator.util.bus.observers;

public abstract class DoubleBusObserver extends BusObserver<Double> {
    public DoubleBusObserver() {
        super(Double.class);
    }
}