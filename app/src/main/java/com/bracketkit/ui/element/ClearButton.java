package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ClearButton extends MyButton{

    private TextView tvOutput;

    public ClearButton(Button button, ArrayList<Character> chars, TextView tvInput, TextView tvOutput) {
        super(button, chars, tvInput);
        this.tvOutput = tvOutput;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        tvInput.setText("0");
        tvOutput.setText("");
    }
}
