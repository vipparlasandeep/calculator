package com.example.calculator.model;

public class CalculatorRequest {
    private String operation;
    private double a;
    private double b;

    public CalculatorRequest() {}

    public CalculatorRequest(String operation, double a, double b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
