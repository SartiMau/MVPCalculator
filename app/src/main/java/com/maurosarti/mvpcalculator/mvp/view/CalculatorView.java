package com.maurosarti.mvpcalculator.mvp.view;

import android.app.Activity;
import butterknife.ButterKnife;

public class CalculatorView extends ActivityView{

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public String getMathAccount() {
        return null;
    }

    public void setResult(int result) {

    }

}
