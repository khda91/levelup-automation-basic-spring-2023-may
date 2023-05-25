package ru.levelp.at.lesson03.unit.testing.tools.data.providers.external;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

class CalculatorExternalDataProviderTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " before each");
        calculator = new CalculatorImpl();
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson03.unit.testing.tools.data.providers.external.ExternalDataProvider"
        + "#addDataProvider")
    void addCalculatorTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println(this.getClass().getName() + " addCalculatorTest");
        var actual = calculator.add(a, b);

        assertEquals(expected, actual, "Сложение работает не правильно!!!");
    }

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson03.unit.testing.tools.data.providers.external.ExternalDataProvider"
        + "#multiplyDataProvider")
    void multiplyCalculatorTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println(this.getClass().getName() + " multiplyCalculatorTest");
        var actual = calculator.multiply(a, b);

        assertEquals(expected, actual, "Умножение работает не правильно!!!");
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " after each");
        calculator = null;
    }
}
