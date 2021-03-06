package com.bracketkit.ui.element;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class EqualsButton extends MyButton{
    private TextView tvOutput;
    private double roundOff;
    private double output;
    private double number;
    private double operation;
    private boolean warningControl;
    private boolean numberLimit;
    boolean consists;
    private ArrayList<String> signs;
    private ArrayList<Double> numbers;

    public EqualsButton() { /* używane do testów */
    }

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
        ArrayList<String> allStrings = new ArrayList<>();
        String val = "";
        String lastString;
        numberLimit = true;
        warningControl = true;
        consists = false;
        signs = new ArrayList<>();
        numbers = new ArrayList<>();
        char[] operations = new char[]{'+','-', '/', '*', '^', '%'};

        for (int i = 0; i < text.length(); i++) {
            char checkedChar = text.charAt(i);
            int j;

            for (j = 0; j < operations.length; j++) {
                if(checkedChar == operations[j]){
                    consists = true;
                    break;
                }
            }

            if (consists) {
                allStrings.add(val);
                allStrings.add(operations[j]+"");
                val = "";
            } else {
                val += checkedChar;
            }

            consists = false;
        }
        if(!val.equals(""))
            allStrings.add(val);

        lastString = allStrings.get(allStrings.size() - 1);

        /* usuwanie znaku na koncu działania */
        for (char operation : operations) {
            if (lastString.charAt(0) == operation) {
                newInput = tvInput.getText().toString();
                newInput = newInput.substring(0, newInput.length() - 1);
                tvInput.setText(newInput);
                allStrings.remove(allStrings.size() - 1);
            }
        }

        /* rozkładanie na dwie listy */
        for (int i = 0; i < allStrings.size(); i++) {

            if (i % 2 == 0) {
                number = Double.parseDouble(allStrings.get(i));
                numbers.add(number);
                if (number >= pow(10,13)) {
                    numberLimit = false;
                }
            } else signs.add(allStrings.get(i));
        }

        output = sequenceMathematicalOperation(numbers, signs);
        if (warningControl) {
            if (output <= pow(10,13) && numberLimit){
                roundOff = (double) Math.round(output * 100000) / 100000;
                output = roundOff;
                tvOutput.setText(Double.toString(output));
            } else tvOutput.setText("Too large number!");

        }
        else tvOutput.setText("Operation error!");
    }


    /* z uwzględnioną kolejnością wykonywania dzaiałń */
    private double sequenceMathematicalOperation (ArrayList<Double> list_0, ArrayList<String> list_1) {

        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < list_1.size(); j++) {
                switch (i) {
                    case 1:
                        j = exponentiationAndModulo(list_0, list_1, j);
                        break;
                    case 2:
                        j = multiplicationAndDivision(list_0, list_1, j);
                        break;
                    case 3:
                        j = addAndSubtraction(list_0, list_1, j);
                }
            }
        }
        return list_0.get(0);
    }

    protected int exponentiationAndModulo(ArrayList<Double> list_0, ArrayList<String> list_1, int i) {

        switch (list_1.get(i).charAt(0)) {
            case '^':
                operation = pow(list_0.get(i),list_0.get(i + 1));
                list_1.remove(i);
                list_0.remove(i + 1);
                list_0.remove(i);
                list_0.add(i, operation);
                return i - 1;

            case '%':
                if (list_0.get(i + 1).equals(0.0)) {
                    warningControl = false;
                    return list_1.size();
                }
                operation = list_0.get(i) % list_0.get(i + 1);
                list_1.remove(i);
                list_0.remove(i + 1);
                list_0.remove(i);
                list_0.add(i, operation);
                return i - 1;
        }
        return i;
    }

    protected int multiplicationAndDivision (ArrayList<Double> list_0, ArrayList<String> list_1, int i) {

        switch (list_1.get(i).charAt(0)) {
            case '*':
                operation = list_0.get(i) * list_0.get(i + 1);
                list_1.remove(i);
                list_0.remove(i + 1);
                list_0.remove(i);
                list_0.add(i, operation);
                return i - 1;
            case '/':
                if (list_0.get(i + 1).equals(0.0)) {
                    warningControl = false;
                    return list_1.size();
                }
                operation = list_0.get(i) / list_0.get(i + 1);
                list_1.remove(i);
                list_0.remove(i + 1);
                list_0.remove(i);
                list_0.add(i, operation);
                return i - 1;
        }
        return i;
    }

    protected int addAndSubtraction(ArrayList<Double> list_0, ArrayList<String> list_1, int i) {

        switch (list_1.get(i).charAt(0)) {
            case '+':
                operation = list_0.get(i) + list_0.get(i + 1);
                list_1.remove(i);
                list_0.remove(i + 1);
                list_0.remove(i);
                list_0.add(i, operation);
                return i - 1;
            case '-':
                operation = list_0.get(i) - list_0.get(i + 1);
                list_1.remove(i);
                list_0.remove(i + 1);
                list_0.remove(i);
                list_0.add(i, operation);
                return i - 1;
        }
        return i;
    }
}