package com.example.assignment1_simple_calculator;

import java.util.ArrayList;

public class CalculatorClass {

    //one record for history users' actions
    public static String history = "";
    //ArrayList to store String history as elements of ArrayList
    public static ArrayList<String> historyArrayList = new ArrayList<>();
    //String for history list for advanced version
    public static String historyList = "";

    public static boolean isNumber(String s) {
        switch (s) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                return true;
        }
        return false;
    }

    public static boolean isOperator(String s) {
        switch (s) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;
    }

    public static void push(String symbol) {
        if (symbol.equals("=")) {
            historyArrayList.clear();
            history += symbol;
            parseStringToArrayList(history);
        } else {
            history += symbol;
        }
    }

    public static void parseStringToArrayList(String s) {
        String number = "";
        String symbol;
        for (int i = 0; i < s.length(); i++) {
            symbol = "" + s.charAt(i);
            if (isNumber(symbol)) {
                number += symbol;
            } else {
                historyArrayList.add(number);
                historyArrayList.add(symbol);
                number = "";
            }
        }
    }

    public static void calculate() {
        double result = Double.parseDouble(historyArrayList.get(0));
        double operand;
        String operator;
        for (int i = 0; i < historyArrayList.size() - 2; i = i + 2) {
            operator = historyArrayList.get(i + 1);
            operand = Double.parseDouble(historyArrayList.get(i + 2));
            result = simpleCalculate(result, operand, operator);
        }
        history = history + result;

    }

    public static double simpleCalculate(double n1, double n2, String oper) {
        double result = 0;
        switch (oper) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
        }
        return result;
    }
}
