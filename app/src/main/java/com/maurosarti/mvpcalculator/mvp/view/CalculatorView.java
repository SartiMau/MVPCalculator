package com.maurosarti.mvpcalculator.mvp.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import com.maurosarti.mvpcalculator.R;

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

        btnBorrar.setEnabled(false);
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
        int btnId = btn.getId();
        switch (btnId){
            case R.id.btnNum0:  writeTextView(txtAccount, "0");
                break;
            case R.id.btnNum1:  writeTextView(txtAccount, "1");
                break;
            case R.id.btnNum2:  writeTextView(txtAccount, "2");
                break;
            case R.id.btnNum3:  writeTextView(txtAccount, "3");
                break;
            case R.id.btnNum4:  writeTextView(txtAccount, "4");
                break;
            case R.id.btnNum5:  writeTextView(txtAccount, "5");
                break;
            case R.id.btnNum6:  writeTextView(txtAccount, "6");
                break;
            case R.id.btnNum7:  writeTextView(txtAccount, "7");
                break;
            case R.id.btnNum8:  writeTextView(txtAccount, "8");
                break;
            case R.id.btnNum9:  writeTextView(txtAccount, "9");
                break;
            case R.id.btnSuma:  writeOperatorTextView(txtAccount, "+");
                break;
            case R.id.btnResta:  writeOperatorTextView(txtAccount, "-");
                break;
            case R.id.btnMultiplicacion:  writeOperatorTextView(txtAccount, "*");
                break;
            default: writeOperatorTextView(txtAccount, "/");
        }
        btnBorrar.setEnabled(true);
    }

    private void writeOperatorTextView(TextView textView, String operator) {
        writeTextView(textView, operator);
        disableOperators();
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

    private void writeTextView(TextView textView, String digit) {
        textView.setText(txtAccount.getText().toString() + digit);
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
