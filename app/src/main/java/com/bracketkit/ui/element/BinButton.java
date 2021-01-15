package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bracketkit.R;

import java.util.ArrayList;

public class BinButton extends MyButton{

    private ViewFlipper viewFlipper;

    public BinButton(Button button, ArrayList<Character> chars, TextView tvInput, ViewFlipper viewFlipper) {
        super(button, chars, tvInput);
        this.viewFlipper = viewFlipper;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        viewFlipper.setDisplayedChild(1);
    }

}
