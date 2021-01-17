package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SepButton extends MyButton{

    private String sign = ".";

    public SepButton(Button button, ArrayList<Character> chars, TextView tvInput) {
        super(button, chars, tvInput);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if (fun())
            validate(sign, tvInput);
    }

    public boolean fun () {
        char[] operations = new char[] {'+','-', '/', '*', '^', '%', '.'};
        char[] lastChar = new char[50];
        ArrayList<Character> last = new ArrayList<>();
        char checkedChar;
        String text = tvInput.getText().toString();

        for (int i = 0; i < tvInput.length(); i++) {
            checkedChar = text.charAt(i);

            for (int j = 0; j < operations.length; j++) {

                if (checkedChar == operations[j]) {
                    last.add(checkedChar);
                    System.out.println(last);
                    break;
                }
            }
        }

        if (last.size() == 1) {
            if (last.get(last.size() - 1).equals('.')){
                return false;
            }
        }
        if (last.size() > 1) {
            if (last.get(last.size() - 1).equals('.') || last.get(last.size() - 2).equals('.')){
                return false;
            }
        }

        return true;
    }
}
