package com.maurosarti.mvpcalculator.mvp.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maurosarti.mvpcalculator.R;
import com.maurosarti.mvpcalculator.util.bus.RxBus;
import com.maurosarti.mvpcalculator.util.bus.observers.ResultButtonPressedBusObserver;

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

    @OnClick({R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4, R.id.btnNum5, R.id.btnNum6,
            R.id.btnNum7, R.id.btnNum8, R.id.btnNum9, R.id.btnSuma, R.id.btnResta, R.id.btnMultiplicacion,
            R.id.btnDivision, R.id.btnBorrar})
    public void calculatorButtonPressed(Button btn){
        boolean borro = false;
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
            case R.id.btnDivision:  writeOperatorTextView(txtAccount, "/");
                break;
            default: removeLastDigit(txtAccount);
                borro = true;
                break;
        }
        if(!borro) {
            btnBorrar.setEnabled(true);
        }
    }

    private void writeOperatorTextView(TextView textView, String operator) {
        writeTextView(textView, operator);
        disableOperators();
    }

    private void disableOperators() {
        btnSuma.setEnabled(false);
        btnResta.setEnabled(false);
        btnMultiplicacion.setEnabled(false);
        btnDivision.setEnabled(false);
    }

    private void removeLastDigit(TextView textView) {
        String subString = textView.getText().toString().substring(0, textView.getText().toString().length()-1);
        char lastDigit = textView.getText().toString().charAt(textView.getText().toString().length()-1);

        textView.setText(subString);

        if (isOperand(lastDigit)){
            enableOperators();
        }

        if(txtAccount.getText().toString().isEmpty()){
            btnBorrar.setEnabled(false);
        } else {
            btnBorrar.setEnabled(true);
        }
    }

    public boolean isOperand(char lastDigit) {
        if(lastDigit == '+' || lastDigit == '-' || lastDigit == '*' || lastDigit == '/'){
            return true;
        }
        return false;
    }


    private void enableOperators() {
        btnSuma.setEnabled(true);
        btnResta.setEnabled(true);
        btnMultiplicacion.setEnabled(true);
        btnDivision.setEnabled(true);
    }

    private void writeTextView(TextView textView, String digit) {
        textView.setText(txtAccount.getText().toString() + digit);
    }

    @OnClick(R.id.btnIgual)
    public void resultButtonPressed() {
        RxBus.post(new ResultButtonPressedBusObserver.ResultButtonPressed(txtAccount.getText().toString()));
    }
}
