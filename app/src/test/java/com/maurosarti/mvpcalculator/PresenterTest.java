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
        when(model.parseFirstNumber("5+8")).thenReturn("5");
        when(view.getAccount()).thenReturn("5+8");
        presenter.onResultButtonPressed();
        verify(view).setResult("13");
        verify(view).getAccount();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDoMul(){
        when(model.solve(5, 8, "*")).thenReturn("40");
        when(model.parseFirstNumber("5*8")).thenReturn("5");
        when(view.getAccount()).thenReturn("5*8");
        presenter.onResultButtonPressed();
        verify(view).setResult("40");
        verify(view).getAccount();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDoSub(){
        when(model.solve(10, 8, "-")).thenReturn("2");
        when(model.parseFirstNumber("10-8")).thenReturn("10");
        when(view.getAccount()).thenReturn("10-8");
        presenter.onResultButtonPressed();
        verify(view).setResult("2");
        verify(view).getAccount();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void shouldDoDiv(){
        when(model.solve(256, 2, "/")).thenReturn("128");
        when(model.parseFirstNumber("256/2")).thenReturn("256");
        when(view.getAccount()).thenReturn("256/2");
        presenter.onResultButtonPressed();
        verify(view).setResult("128");
        verify(view).getAccount();
        verifyNoMoreInteractions(view);
    }

    @Test
    public void additionIsCorrect() {
        assertEquals(4, 2 + 2);
    }
}