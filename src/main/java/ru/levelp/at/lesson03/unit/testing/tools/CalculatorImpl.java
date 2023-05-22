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
}
