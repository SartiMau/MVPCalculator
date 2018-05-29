package com.maurosarti.mvpcalculator;

import com.maurosarti.mvpcalculator.mvp.model.CalculatorModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ModelTest {
    private CalculatorModel model;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        model= new CalculatorModel();
    }

    @Test
    public void shouldDoSum(){
        assertEquals("13", model.solve(5, 8, "+"));
    }

    @Test
    public void shouldDoMul(){
        assertEquals("40", model.solve(5, 8, "*"));
    }

    @Test
    public void shouldDoSub(){
        assertEquals("4", model.solve(12, 8, "-"));
    }

    @Test
    public void shouldDoDiv(){
        assertEquals("128", model.solve(256, 2, "/"));
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}