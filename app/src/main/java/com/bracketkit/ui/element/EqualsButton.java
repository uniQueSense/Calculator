package com.bracketkit.ui.element;

import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EqualsButton extends MyButton{
    private TextView tvOutput;
    public EqualsButton(Button button, ArrayList<Character> chars, TextView tvInput, TextView tvOutput) {
        super(button, chars, tvInput);
        this.tvOutput = tvOutput;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        String text = tvInput.getText().toString();
        calculate(text);
    }

    protected void calculate(String text) {
        char[] operations = new char[]{'+','-', '/', '*', 'm', '^', '%'};
        ArrayList<String> allStrings = new ArrayList<>();
        ArrayList<String> signs = new ArrayList<>();
        ArrayList<Double> numbers = new ArrayList<>();
        String lastString = new String();
        double number;

        String val = "";
        boolean consists = false;

        for (int i = 0; i < text.length(); i++) {
            char checkedChar = text.charAt(i);
            int j;

            for (j = 0; j < operations.length; j++) {
                if(checkedChar == operations[j]){
                    consists = true;
                    break;
                }
            }

            for (char operation :
                    operations) {
                if(checkedChar == operation)
                    consists = true;
            }

            if(consists){
                allStrings.add(val);
                allStrings.add(operations[j]+"");
                val = "";
            }else{
                val += checkedChar;
            }

            consists = false;
        }
        if(!val.equals(""))
            allStrings.add(val);
        
        lastString = allStrings.get(allStrings.size() - 1);
        char s = lastString.charAt(0);

        /**
         * usuwanie znaku na koncu działania
         * */

        for (int i = 0; i < operations.length; i++) {
            if (s == operations[i]){
                newInput = tvInput.getText().toString();
                newInput = newInput.substring(0, newInput.length() - 1);
                tvInput.setText(newInput);

                allStrings.remove(allStrings.size() - 1);
            }
        }
        /**
         * rozłożenie całej tablicy na dwie osobne
         * */

        for (int i = 0; i < allStrings.size(); i++) {
            if (i % 2 == 0){
                number = Double.parseDouble(allStrings.get(i));
                numbers.add(number);
            }else signs.add(allStrings.get(i));
        }

        System.out.println(numbers);
        System.out.println(signs);

        calculate(numbers, signs);
    }

    public void calculate(ArrayList<Double> list_0, ArrayList<String> list_1){

        Stack<Double> stack_0 = new Stack();
        Collections.reverse(list_0);
        stack_0.addAll(list_0);
        double output = 0.0;

        for (int i =0; i < list_1.size(); i++){
            String sign = list_1.get(i);
            List<Double> args = new ArrayList<>();
            args.add(stack_0.pop());
            args.add(stack_0.pop());

            switch (sign) {
                case "+":
                    output = Double.sum(args.get(0), args.get(1));
                    stack_0.push(output);
                    break;
                case "-":
                    output = Double.sum(args.get(0), -args.get(1));
                    stack_0.push(output)
                    ;
                    break;
                case "*":
                    output = args.get(0) * args.get(1);
                    stack_0.push(output);
                    break;
                case "/":
                    output = args.get(0) / args.get(1);
                    stack_0.push(output);
                    break;
                case "^":
                    output = Math.pow(args.get(0), args.get(1));
                    stack_0.push(output);
                    break;
                case "%":
                    output = args.get(0) % args.get(1);
                    stack_0.push(output);
            }
        }
        if (list_1.size() == 0) {
            output = list_0.get(0);
        }

     // System.out.println(stack_0);
        System.out.println(output);
        double roundOff = (double) Math.round(output * 100000) / 100000;
        output= roundOff;
        tvOutput.setText(Double.toString(output));
    }
}
