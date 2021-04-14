package com.company;

public class Calculator {

    public int Id;
    public String Method_name;
    public double Input1;
    public double Input2;
    public double Input3;
    public double Result1;
    public String Exception;

    public Calculator() {
    }

    public Calculator(int id, String method_name, double input1, double input2, double input3, double result1, String exception) {
        Id = id;
        Method_name = method_name;
        Input1 = input1;
        Input2 = input2;
        Input3 = input3;
        Result1 = result1;
        Exception = exception;
    }

    public double add(double a, double b)
    {
        return a + b;
    }
    public double sub(double a, double b)
    {
        return a - b;
    }
    public double mul(double a, double b)
    {
        return a * b;
    }
    public double div(double a, double b)
    {
        return a / b;
    }
}
