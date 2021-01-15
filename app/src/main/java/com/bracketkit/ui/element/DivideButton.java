package com.bracketkit.ui.element;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DivideButton extends MyButton {

    private Color color1, color2;
    private String sign = "/";


    public DivideButton(Button button, ArrayList<Character> chars, TextView tvInput) {
        super(button, chars, tvInput);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        validate(sign, tvInput);
        //tvInput.setText(tvInput.getText() + "/");
    }


}
