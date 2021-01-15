package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberButton extends MyButton{

    private TextView tvOutput;
    private boolean decimalActive;

    private  boolean active;
    public NumberButton(Button button, ArrayList<Character> chars, TextView tvInput, TextView tvOutput, boolean active, boolean decimalActive) {
        super(button, chars, tvInput);
        this.tvOutput = tvOutput;
        this.active = active;
        this.decimalActive = decimalActive;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        tvInput.setText(tvInput.getText() + button.getText().toString());

        if(active)
            convert(tvInput, tvOutput);
    }

    private void convert(TextView textView1, TextView textView2) {

        if (decimalActive) {
            String value = textView1.getText().toString();
            int argument = Integer.parseInt(value);
            textView2.setText(Integer.toBinaryString(argument));
        } else {
            String value = textView1.getText().toString();
            int argument = Integer.parseInt(value,2);
            textView2.setText(Integer.toString(argument));
        }
    }
}
