package com.bracketkit.ui.element;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class EqualsButtonTest {

    @Test
    public void testAdd() {

        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();
        int i;

        list_0.add(4.0);
        list_0.add(9.0);
        list_0.add(1.12345);

        list_1.add("+");
        list_1.add("+");

        EqualsButton equalsButton = new EqualsButton();
        for (i = 0; i < list_1.size(); i++) {
            i = equalsButton.addAndSubtraction(list_0, list_1, i);
        }

        double expected = 14.12345;
        double result0 = list_0.get(i);

        assertEquals(expected, result0);
    }

    @Test
    public void testSubtraction() {
        int i;
        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();

        list_0.add(4.0);
        list_0.add(9.0);
        list_0.add(4.5);
        list_0.add(5.25);

        list_1.add("-");
        list_1.add("-");
        list_1.add("-");

        EqualsButton equalsButton = new EqualsButton();

        for (i = 0; i < list_1.size(); i++) {
            i = equalsButton.addAndSubtraction(list_0, list_1, i);
        }

        double expected = -14.75;
        double result0 = list_0.get(i);

        assertEquals(expected, result0);
    }

    @Test
    public void testAddAndSubtraction() {
        int i;
        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();

        list_0.add(1.234);
        list_0.add(8.112);
        list_0.add(5.23);
        list_0.add(0.0023);

        list_1.add("-");
        list_1.add("+");
        list_1.add("-");

        EqualsButton equalsButton = new EqualsButton();

        for (i = 0; i < list_1.size(); i++) {
            i = equalsButton.addAndSubtraction(list_0, list_1, i);
        }

        double expected = 1.234 - 8.112 + 5.23 - 0.0023;
        double result0 = list_0.get(i);

        assertEquals(expected, result0);
    }

}