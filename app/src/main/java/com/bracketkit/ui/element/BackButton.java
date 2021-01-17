package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BackButton extends MyButton{
    private String newInput;

    public BackButton(Button button, ArrayList<Character> chars, TextView tvInput) {
        super(button, chars, tvInput);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if (tvInput.getText() != "0") {
            newInput = tvInput.getText().toString();
            newInput = newInput.substring(0, newInput.length() - 1);
            tvInput.setText(newInput);

            if (tvInput.length() == 0) tvInput.setText("0");
        }
    }
}
