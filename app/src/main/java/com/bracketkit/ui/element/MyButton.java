package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class MyButton implements View.OnClickListener {

    protected Button button;
    protected ArrayList<Character> chars;
    protected TextView tvInput;
    protected String newInput, lastSign;

    public MyButton(Button button, ArrayList<Character> chars, TextView tvInput) {
        this.button = button;
        this.chars = chars;
        this.tvInput = tvInput;

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }

    protected void validate(String sign){

        if(tvInput.length() != 0) {
            lastSign = tvInput.getText().toString();
            lastSign = lastSign.substring(lastSign.length() - 1);

            if (lastSign.equals("+") || lastSign.equals("-") || lastSign.equals("*") || lastSign.equals("/")
                    || lastSign.equals("%") || lastSign.equals("m")
                    || lastSign.equals(".") || lastSign.equals("^")) {
                newInput = tvInput.getText().toString();
                newInput = newInput.substring(0, newInput.length() - 1);
                tvInput.setText(newInput + sign);
            }
            else tvInput.setText(tvInput.getText() + sign);
        }
        else tvInput.setText("0" + sign);

    }
}
