package com.maurosarti.mvpcalculator.util.bus.observers;

public abstract class BooleanBusObserver extends BusObserver<Boolean> {
    public BooleanBusObserver() {
        super(Boolean.class);
    }
}