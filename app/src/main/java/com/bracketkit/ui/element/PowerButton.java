package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PowerButton extends MyButton{

    private String sign = "^";

    public PowerButton(Button button, ArrayList<Character> chars, TextView tvInput) {
        super(button, chars, tvInput);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        validate(sign);

       // tvInput.setText(tvInput.getText() + "^");
    }

}
