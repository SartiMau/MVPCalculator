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
    public void shouldDoParse(){
        assertEquals("256", model.parseFirstNumber("256/2"));
    }

    @Test
    public void shouldBeOperatorDiv(){
        assertEquals("true", String.valueOf(model.isOperand('/')));
    }

    @Test
    public void shouldBeOperatorMul(){
        assertEquals("true", String.valueOf(model.isOperand('*')));
    }

    @Test
    public void shouldBeOperatorSum(){
        assertEquals("true", String.valueOf(model.isOperand('+')));
    }

    @Test
    public void shouldBeOperatorSub(){
        assertEquals("true", String.valueOf(model.isOperand('-')));
    }

    @Test
    public void additionIsCorrect() {
        assertEquals(4, 2 + 2);
    }
}