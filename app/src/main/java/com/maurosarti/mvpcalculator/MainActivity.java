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

    @BindView(R.id.txtAccount) TextView txtAccount;
    @BindView(R.id.btnBorrar) Button btnBorrar;

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
        presenter.onResultButtonPressed(txtAccount.getText().toString());
    }

    @OnClick(R.id.btnBorrar)
    public void removeLastDigit() {
        String subString = txtAccount.getText().toString().substring(0, txtAccount.getText().toString().length()-1);
        char lastDigit = txtAccount.getText().toString().charAt(txtAccount.getText().toString().length()-1);

        txtAccount.setText(subString);

        if (presenter.isOperand(lastDigit)){
            presenter.enableOperators();
        }

        if(txtAccount.getText().toString().isEmpty()){
            btnBorrar.setEnabled(false);
        } else {
            btnBorrar.setEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
