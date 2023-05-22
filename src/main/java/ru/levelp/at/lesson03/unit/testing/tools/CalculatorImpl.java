package ru.levelp.at.lesson03.unit.testing.tools;

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
        if (b.compareTo(new BigDecimal("0.0")) == 0) {
            throw new IllegalArgumentException("Делить на 0 нельзя!!!");
        }
        return a.divide(b);
    }
}
