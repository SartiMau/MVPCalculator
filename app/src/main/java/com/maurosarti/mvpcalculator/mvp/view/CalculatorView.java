package com.maurosarti.mvpcalculator.mvp.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.maurosarti.mvpcalculator.R;
import com.maurosarti.mvpcalculator.util.bus.RxBus;
import com.maurosarti.mvpcalculator.util.bus.observers.CalculatorButtonPressedBusObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorView extends ActivityView{

    @BindView(R.id.txtAccount) TextView txtAccount;
    @BindView(R.id.txtResult) TextView txtResult;

    @BindView(R.id.btnSuma) Button btnSuma;
    @BindView(R.id.btnResta) Button btnResta;
    @BindView(R.id.btnMultiplicacion) Button btnMultiplicacion;
    @BindView(R.id.btnDivision) Button btnDivision;
    @BindView(R.id.btnBorrar) Button btnBorrar;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);

        disableBtnBorrar();
    }

    public void setResult(String result) {
        txtResult.setText(result);
    }

    @OnClick(R.id.btnNuevo)
    public void nuevoButtonPressed(){
        txtAccount.setText("");
        txtResult.setText("");
        enableOperators();
        btnBorrar.setEnabled(false);
    }

    @OnClick({R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5, R.id.btnNum6,
            R.id.btnNum7, R.id.btnNum8, R.id.btnNum9, R.id.btnSuma, R.id.btnResta, R.id.btnMultiplicacion,
            R.id.btnDivision})
    public void calculatorButtonPressed(Button btn){
        RxBus.post(new CalculatorButtonPressedBusObserver.CalculatorButtonPressed(btn.getText().toString()));
    }

    public void disableOperators() {
        btnSuma.setEnabled(false);
        btnResta.setEnabled(false);
        btnMultiplicacion.setEnabled(false);
        btnDivision.setEnabled(false);
    }

    public void enableOperators() {
        btnSuma.setEnabled(true);
        btnResta.setEnabled(true);
        btnMultiplicacion.setEnabled(true);
        btnDivision.setEnabled(true);
    }

    public String getAccount(){
        return txtAccount.getText().toString();
    }

    public void setAccount(String account){
        this.txtAccount.setText(account);
    }

    public void disableBtnBorrar() {
        btnBorrar.setEnabled(false);
    }

    public void enableBtnBorrar() {
        btnBorrar.setEnabled(true);
    }
}
