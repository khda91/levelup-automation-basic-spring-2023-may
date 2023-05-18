package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator {

    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b.compareTo(new BigDecimal("0")) < 1) {
            throw new IllegalArgumentException("Делить на 0 нельзя!!!");
        }
        return a.divide(b);
    }

    @Override
    public BigDecimal power(BigDecimal a, int p) {
        if (p < 0) {
            throw new IllegalArgumentException("Степерь не может быть отрицательной в нашей реализации!!!");
        } else if (p == 0) {
            return new BigDecimal("1");
        }

        var res = new BigDecimal("1");
        for (int i = 0; i < p; i++) {
            res.multiply(a);
        }

        return res;
    }
}
