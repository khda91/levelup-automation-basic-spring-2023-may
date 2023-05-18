package ru.levelp.at.lesson02.git;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        System.out.println("2.4 + 2.8 = " + calculator.add(2.4, 2.8));
        System.out.println("5.3 + 0.7 = " + calculator.add(5.3, 0.7));
        System.out.println("-0.7 + 0.7 = " + calculator.add(-0.7, 0.7));

        System.out.println("2.4 - 2.8 = " + calculator.subtract(2.4, 2.8));
        System.out.println("5.3 - 0.7 = " + calculator.subtract(5.3, 0.7));
        System.out.println("-0.9 - 0.7 = " + calculator.subtract(-0.9, 0.7));

        System.out.println("2.4 * 2.8 = " + calculator.multiply(2.4, 2.8));
        System.out.println("5.3 * 0.7 = " + calculator.multiply(5.3, 0.7));
        System.out.println("0.3 * 0.7 = " + calculator.multiply(0.3, 0.7));

        System.out.println("2.4 / 2.8 = " + calculator.divide(2.4, 2.8));
        System.out.println("5.3 / 0.7 = " + calculator.divide(5.3, 0.7));
        System.out.println("0.0 / 0.7 = " + calculator.divide(0.0, 0.7));

        System.out.println("5 power 2 = " + calculator.power(5, 2));
        System.out.println("5 power 3 = " + calculator.power(5, 3));
    }
}
