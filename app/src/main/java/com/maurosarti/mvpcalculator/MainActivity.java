package com.maurosarti.mvpcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.maurosarti.mvpcalculator.mvp.model.CalculatorModel;
import com.maurosarti.mvpcalculator.mvp.presenter.CalculatorPresenter;
import com.maurosarti.mvpcalculator.mvp.view.CalculatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnIgual)
    public void resultButtonPressed() {
        presenter.onResultButtonPressed();
    }

    @OnClick(R.id.btnBorrar)
    public void removeLastDigit() {
        presenter.removeLastDigit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregister();
    }
}
