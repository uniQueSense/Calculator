package com.bracketkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.bracketkit.ui.element.BackButton;
import com.bracketkit.ui.element.BinButton;
import com.bracketkit.ui.element.ClearButton;
import com.bracketkit.ui.element.DecButton;
import com.bracketkit.ui.element.MyButton;
import com.bracketkit.ui.element.NumberButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ConverterActivity extends AppCompatActivity {

    private TextView tvInput, tvOutput;
    private MyButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private MyButton btnDec, btnBin;
    private MyButton btnClear, btnBackspace;

    private TextView tvInputt, tvOutputt;
    private MyButton btn00, btn11;
    private MyButton btnClearr, btnBackspacee;

    private ArrayList<Character> chars;
    private ViewFlipper viewFlipper;

    private ImageButton menuButton;
    private Button calculatorButton, converterButton;
    private FrameLayout menuLayout;
    private FrameLayout container;
    private boolean activeMenu;

    private boolean converterActive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        getSupportActionBar().hide();

        activeMenu = false;
        converterActive = true;

        viewFlipper = findViewById(R.id.viev_flip);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        tvInput.setText("0");

        tvInputt = findViewById(R.id.tvInputt);
        tvOutputt = findViewById(R.id.tvOutputt);

        tvInputt.setText("0");

        menuButton = findViewById(R.id.menu_button);
        menuLayout = findViewById(R.id.menu_block);
        calculatorButton = findViewById(R.id.calculator_button);
        converterButton = findViewById(R.id.converter_button);


        btnClear = new ClearButton(findViewById(R.id.clear), chars, tvInput, tvOutput);
        btnBackspace = new BackButton(findViewById(R.id.backspace), chars, tvInput);

        btnDec = new DecButton(findViewById(R.id.decimal), chars, tvInputt, viewFlipper);
        btnBin = new BinButton(findViewById(R.id.binary), chars, tvInputt, viewFlipper);

        btnClearr = new ClearButton(findViewById(R.id.clearr), chars, tvInputt, tvOutputt);
        btnBackspacee = new BackButton(findViewById(R.id.backspacee), chars, tvInputt);
        btn00 = new NumberButton(findViewById(R.id.zeroo), chars, tvInputt, tvOutputt, converterActive, false);
        btn11 = new NumberButton(findViewById(R.id.onee), chars, tvInputt, tvOutputt, converterActive, false);

        btn0 = new NumberButton(findViewById(R.id.zero), chars, tvInput, tvOutput, converterActive, true);
        btn1 = new NumberButton(findViewById(R.id.one), chars, tvInput, tvOutput, converterActive, true);
        btn2 = new NumberButton(findViewById(R.id.two), chars, tvInput, tvOutput, converterActive, true);
        btn3 = new NumberButton(findViewById(R.id.three), chars, tvInput, tvOutput, converterActive, true);
        btn4 = new NumberButton(findViewById(R.id.four), chars, tvInput, tvOutput, converterActive, true);
        btn5 = new NumberButton(findViewById(R.id.five), chars, tvInput, tvOutput, converterActive, true);
        btn6 = new NumberButton(findViewById(R.id.six), chars, tvInput, tvOutput, converterActive, true);
        btn7 = new NumberButton(findViewById(R.id.seven), chars, tvInput, tvOutput, converterActive, true);
        btn8 = new NumberButton(findViewById(R.id.eight), chars, tvInput, tvOutput, converterActive, true);
        btn9 = new NumberButton(findViewById(R.id.nine), chars, tvInput, tvOutput, converterActive, true);

        menuButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int width = menuLayout.getWidth();
                int height = menuLayout.getHeight();
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width,height);

                if(!activeMenu){
                    params.leftMargin = 0;
                    menuLayout.setLayoutParams(params);
                    activeMenu = true;
                }
                else {
                    params.leftMargin = -600;
                    menuLayout.setLayoutParams(params);
                    activeMenu = false;
                }
            }
        });


        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ConverterActivity.this, CalculatorActivity.class);
                startActivity(intent);
                finish();
            }
        });

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Converter already exist", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });
    }
//    @Override
//    public void onEnterAnimationComplete() {
//        super.onEnterAnimationComplete();
//        Toast.makeText(this, "Animation Completed", Toast.LENGTH_SHORT).show();
//        Animation anim = AnimationUtils.loadAnimation(this, R.layout.activity_main);
//        textView.startAnimation(anim);
//    }
}