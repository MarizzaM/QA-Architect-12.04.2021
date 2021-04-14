package com.company;

import org.junit.Test;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestWithDB {

    CalculatorDAO repo = new CalculatorDAO("jdbc:sqlite:C:/SQLite/CalcData.db");
    @Test
    public void testAdd() {
        ArrayList<Calculator>  methodData =
                repo.select("SELECT * FROM TestData where NAME = 'add'");
        Calculator calc = new Calculator();

        for (Calculator one_row : methodData) {
            double actual_result =  calc.add(one_row.Input1, one_row.Input2);
            assertEquals(one_row.Result1, actual_result);
        }
    }

    @Test
    public void testSub() {
        ArrayList<Calculator>  methodData =
                repo.select("SELECT * FROM TestData where NAME = 'sub'");
        Calculator calc = new Calculator();

        for (Calculator one_row : methodData) {
            double actual_result =  calc.sub(one_row.Input1, one_row.Input2);
            assertEquals(one_row.Result1, actual_result);
        }
    }

    @Test
    public void testMul() {
        ArrayList<Calculator>  methodData =
                repo.select("SELECT * FROM TestData where NAME = 'mul'");
        Calculator calc = new Calculator();

        for (Calculator one_row : methodData) {
            double actual_result =  calc.mul(one_row.Input1, one_row.Input2);
            assertEquals(one_row.Result1, actual_result);
        }
    }
    @Test
    public void testDiv() {
        ArrayList<Calculator>  methodData =
                repo.select("SELECT * FROM TestData where NAME = 'div'");
        Calculator calc = new Calculator();

        for (Calculator one_row : methodData) {
            double actual_result =  calc.div(one_row.Input1, one_row.Input2);
            assertEquals(one_row.Result1, actual_result);
        }
    }
}
