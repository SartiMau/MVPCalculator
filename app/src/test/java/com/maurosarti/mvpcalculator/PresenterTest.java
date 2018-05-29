package com.maurosarti.mvpcalculator;

import com.maurosarti.mvpcalculator.mvp.model.CalculatorModel;
import com.maurosarti.mvpcalculator.mvp.presenter.CalculatorPresenter;
import com.maurosarti.mvpcalculator.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PresenterTest {

    private CalculatorPresenter presenter;
    @Mock CalculatorModel model;
    @Mock CalculatorView view;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void shouldDoSum(){
        when(model.solve(5, 8, "+")).thenReturn("13");
        presenter.onResultButtonPressed("5+8");
        verify(view).setResult("13");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDoMul(){
        when(model.solve(5, 8, "*")).thenReturn("40");
        presenter.onResultButtonPressed("5*8");
        verify(view).setResult("40");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDoSub(){
        when(model.solve(10, 8, "-")).thenReturn("2");
        presenter.onResultButtonPressed("10-8");
        verify(view).setResult("2");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDoDiv(){
        when(model.solve(256, 2, "/")).thenReturn("128");
        presenter.onResultButtonPressed("256/2");
        verify(view).setResult("128");
        verifyNoMoreInteractions(view);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}