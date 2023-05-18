package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        System.out.println("2.4 + 2.8 = " + calculator.add(new BigDecimal(2.4), new BigDecimal(2.8)));
        System.out.println("5.3 + 0.7 = " + calculator.add(new BigDecimal(5.3), new BigDecimal(0.7)));
        System.out.println("-0.7 + 0.7 = " + calculator.add(new BigDecimal(-0.7), new BigDecimal(0.7)));

        System.out.println("2.4 - 2.8 = " + calculator.subtract(new BigDecimal(2.4), new BigDecimal(2.8)));
        System.out.println("5.3 - 0.7 = " + calculator.subtract(new BigDecimal(5.3), new BigDecimal(0.7)));
        System.out.println("-0.9 - 0.7 = " + calculator.subtract(new BigDecimal(-0.9), new BigDecimal(0.7)));

        System.out.println("2.4 * 2.8 = " + calculator.multiply(new BigDecimal(2.4), new BigDecimal(2.8)));
        System.out.println("5.3 * 0.7 = " + calculator.multiply(new BigDecimal(5.3), new BigDecimal(0.7)));
        System.out.println("0.3 * 0.7 = " + calculator.multiply(new BigDecimal(0.3), new BigDecimal(0.7)));

        System.out.println("2.4 / 2.8 = " + calculator.divide(new BigDecimal(2.4), new BigDecimal(2)));
        System.out.println("5.3 / 0.7 = " + calculator.divide(new BigDecimal(5), new BigDecimal(2)));
        System.out.println("0.0 / 0.7 = " + calculator.divide(new BigDecimal(0.0), new BigDecimal(0.1)));

        System.out.println("5 power 2 = " + calculator.power(new BigDecimal(5), 2));
        System.out.println("5 power 3 = " + calculator.power(new BigDecimal(5), 3));

        System.out.println("5! = " + calculator.factorial(5));
        System.out.println("6! = " + calculator.factorial(6));
    }
}
