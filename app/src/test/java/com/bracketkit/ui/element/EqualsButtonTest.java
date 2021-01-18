package com.bracketkit.ui.element;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class EqualsButtonTest {

    @Test
    public void testAdd() {
        int i;
        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();

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

        double expected1 = 1.234 - 8.112 + 5.23 - 0.0023;
        double expected2 = 1.234 - 8.112 + 5.23 + 0.0023;
        double expected3 = 0.0;
        double result = list_0.get(i);

        assertEquals(expected1, result);
        Assert.assertNotEquals(expected2, result);
        Assert.assertNotEquals(expected3, result);
    }

    @Test
    public void testMultiplication() {
        int i;
        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();

        list_0.add(2.24);
        list_0.add(-11.2);
        list_0.add(5.0);

        list_1.add("*");
        list_1.add("*");

        EqualsButton equalsButton = new EqualsButton();

        for (i = 0; i < list_1.size(); i++) {
            i = equalsButton.multiplicationAndDivision(list_0, list_1, i);
        }

        double expected1 = 2.24 * -11.2 * 5.0;
        double expected2 = 1.234 * 8.112;
        double result = list_0.get(i);

        assertEquals(expected1, result);
        Assert.assertNotEquals(expected2, result);
    }
    @Test
    public void testDivision() {
        int i;
        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();

        list_0.add(-2.24);
        list_0.add(11.2);
        list_0.add(5.0);

        list_1.add("/");
        list_1.add("/");

        EqualsButton equalsButton = new EqualsButton();

        for (i = 0; i < list_1.size(); i++) {
            i = equalsButton.multiplicationAndDivision(list_0, list_1, i);
        }
    }

    @Test
    public void testMultiplicationAndDivision() {
        int i;
        ArrayList<Double> list_0 = new ArrayList<>();
        ArrayList<String> list_1 = new ArrayList<>();

        list_0.add(-0.24);
        list_0.add(100.2);
        list_0.add(20.7);

        list_1.add("*");
        list_1.add("/");

        EqualsButton equalsButton = new EqualsButton();

        for (i = 0; i < list_1.size(); i++) {
            i = equalsButton.multiplicationAndDivision(list_0, list_1, i);
        }

        double expected1 = -0.24 * 100.2 / 20.7;
        double expected2 = 0.0;
        double result = list_0.get(i);

        assertEquals(expected1, result);
        Assert.assertNotEquals(expected2, result);
    }



}