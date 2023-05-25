package ru.levelp.at.lesson03.unit.testing.tools.data.providers.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson03.unit.testing.tools.Calculator;
import ru.levelp.at.lesson03.unit.testing.tools.CalculatorImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorInternalDataProviderWithTestInstanceTest {

    Stream<Arguments> addDataProvider() {
        return Stream.of(
            Arguments.of(new BigDecimal("12.0"), new BigDecimal("12.0"), new BigDecimal("24.0")),
            Arguments.of(new BigDecimal("1.0"), new BigDecimal("12.0"), new BigDecimal("13.0")),
            Arguments.of(new BigDecimal("5.0"), new BigDecimal("0.5"), new BigDecimal("5.5"))
        );
    }

    Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
            Arguments.of(new BigDecimal("12.0"), new BigDecimal("12.0"), new BigDecimal("144.00")),
            Arguments.of(new BigDecimal("1.0"), new BigDecimal("12.0"), new BigDecimal("12.00")),
            Arguments.of(new BigDecimal("5.0"), new BigDecimal("0.5"), new BigDecimal("2.50"))
        );
    }

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " before each");
        calculator = new CalculatorImpl();
    }

    @ParameterizedTest
    @MethodSource("addDataProvider")
    void addCalculatorTest(BigDecimal a, BigDecimal b, BigDecimal expected) {
        System.out.println(this.getClass().getName() + " addCalculatorTest");
        var actual = calculator.add(a, b);

        assertEquals(expected, actual, "Сложение работает не правильно!!!");
    }

    @ParameterizedTest
    @MethodSource("multiplyDataProvider")
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
