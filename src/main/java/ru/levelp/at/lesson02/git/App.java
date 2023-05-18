package ru.levelp.at.lesson02.git;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        System.out.println("2.4 + 2.8 = " + calculator.add(2.4, 2.8));
    }
}
