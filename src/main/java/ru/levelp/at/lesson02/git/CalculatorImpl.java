package ru.levelp.at.lesson02.git;

public class CalculatorImpl implements Calculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a* b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Делить на 0 нельзя!!!");
        }
        return a / b;
    }

    @Override
    public double power(double a, int p) {
        if (p < 0) {
            throw new IllegalArgumentException("Степерь не может быть отрицательной в нашей реализации!!!");
        } else if (p == 0) {
            return 1;
        }

        var res = 1.0;
        for (int i = 0; i < p; i++) {
            res *= a;
        }

        return res;
    }

    @Override
    public int factorial(int a) {
        if (a < 1) {
            throw new IllegalArgumentException("Нет факториала для отрицательного числа!!!");
        }

        int f = 1;

        for (int i = 1; i < a + 1; i++) {
            f *= i;
        }

        return f;
    }
}
