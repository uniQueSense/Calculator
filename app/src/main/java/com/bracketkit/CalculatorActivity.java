package com.bracketkit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bracketkit.ui.element.BackButton;
import com.bracketkit.ui.element.ClearButton;
import com.bracketkit.ui.element.DivideButton;
import com.bracketkit.ui.element.EqualsButton;
import com.bracketkit.ui.element.MinusButton;
import com.bracketkit.ui.element.ModButton;
import com.bracketkit.ui.element.MulButton;
import com.bracketkit.ui.element.MyButton;
import com.bracketkit.ui.element.NumberButton;
import com.bracketkit.ui.element.PlusButton;
import com.bracketkit.ui.element.PowerButton;
import com.bracketkit.ui.element.SepButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    private TextView tvInput, tvOutput;
    private MyButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private MyButton btnClear, btnBackspace, btnEquals, btnMinus;
    private MyButton btnMul, btnPower, btnMod, btnSeparator, btnDiv, btnPlus;

    private ImageButton menuButton;
    private Button calculatorButton, converterButton;
    private FrameLayout menuLayout;
    private FrameLayout container;
    private boolean activeMenu;
    private ArrayList<Character> chars;
    private boolean converterActive;
    private boolean decimalActive;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().hide();

        activeMenu = false;
        converterActive = false;
        decimalActive = false;

        container = findViewById(R.id.rl);
        menuLayout = findViewById(R.id.menu_block);
        menuButton = findViewById(R.id.menu_button);

        calculatorButton = findViewById(R.id.calculator_button);
        converterButton = findViewById(R.id.converter_button);

        tvInput = findViewById(R.id.input_screen);
        tvOutput = findViewById(R.id.output_screen);

        tvInput.setText("0");

        btnPlus = new PlusButton(findViewById(R.id.plus), chars, tvInput);
        btnMinus = new MinusButton(findViewById(R.id.minus), chars, tvInput);
        btnMul = new MulButton(findViewById(R.id.multiplication), chars, tvInput);
        btnDiv = new DivideButton(findViewById(R.id.division), chars, tvInput);
        btnPower = new PowerButton(findViewById(R.id.power), chars, tvInput);
        btnMod = new ModButton(findViewById(R.id.modulo), chars, tvInput);
        btnSeparator = new SepButton(findViewById(R.id.decimal_separator), chars, tvInput);

        btnBackspace = new BackButton(findViewById(R.id.backspace), chars, tvInput);
        btnEquals = new EqualsButton(findViewById(R.id.equals), chars, tvInput, tvOutput);
        btnClear = new ClearButton(findViewById(R.id.clear), chars, tvInput, tvOutput);

        btn0 = new NumberButton(findViewById(R.id.zero), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn1 = new NumberButton(findViewById(R.id.one), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn2 = new NumberButton(findViewById(R.id.two), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn3 = new NumberButton(findViewById(R.id.three), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn4 = new NumberButton(findViewById(R.id.four), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn5 = new NumberButton(findViewById(R.id.five), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn6 = new NumberButton(findViewById(R.id.six), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn7 = new NumberButton(findViewById(R.id.seven), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn8 = new NumberButton(findViewById(R.id.eight), chars, tvInput, tvOutput, converterActive, decimalActive);
        btn9 = new NumberButton(findViewById(R.id.nine), chars, tvInput, tvOutput, converterActive, decimalActive);

        menuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int width = menuLayout.getWidth();
                int height = menuLayout.getHeight();


                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
                if (!activeMenu) {
                    params.leftMargin = 0;
                    menuLayout.setLayoutParams(params);

                    activeMenu = true;
                } else {
                    params.leftMargin = -650;
                    menuLayout.setLayoutParams(params);

                    activeMenu = false;
                }

            }
        });


//        container.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                //Log.wtf("XX", "pos x: "+event.getRawX());
//                //Log.wtf("XX", "pos y: "+event.getRawY());
//                float x = event.getRawX();
//                //float y = event.getRawY();
//
//                switch(event.getAction()) {
//
//                    case MotionEvent.ACTION_DOWN:
//
//                        //Log.d("XX", "nacisniecie+ "+ x);
//                        //Log.d("XX", "nacisniecie");
//
//
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//
//                          //Log.wtf("XX", "ujecie:  ");
//
//
//
//                        break;
//                    case MotionEvent.ACTION_UP:
//
//                        //Log.d("XX", "puszczenie+ "+ x);
//                        break;
//                }
//
//                return false;
//            }
//        });

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Calculator already exist", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CalculatorActivity.this, ConverterActivity.class);

                startActivity(intent);
                onEnterAnimationComplete();
                finish();

            }
        });
    }


}