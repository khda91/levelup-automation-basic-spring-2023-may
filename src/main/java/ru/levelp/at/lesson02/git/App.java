package ru.levelp.at.lesson02.git;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        System.out.println("2.4 + 2.8 = " + calculator.add(2.4, 2.8));
        System.out.println("5.3 + 0.7 = " + calculator.add(5.3, 0.7));
    }
}
