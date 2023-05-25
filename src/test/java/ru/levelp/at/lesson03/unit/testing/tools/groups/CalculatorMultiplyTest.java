package ru.levelp.at.lesson03.unit.testing.tools.groups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson03.unit.testing.tools.groups.annotations.IncrementTag;
import ru.levelp.at.lesson03.unit.testing.tools.groups.annotations.PositiveTag;

@PositiveTag
class CalculatorMultiplyTest extends CalculatorBaseTest {

    @BeforeAll
    @Override
    void beforeAll() {
        // super.beforeAll();
        System.out.println("Хей-хей-хей!");
    }

    @Test
    @IncrementTag
    void multiplyCalculatorTest() {
        System.out.println(this.getClass().getName() + " multiplyCalculatorTest");
        var actual = calculator.multiply(new BigDecimal("12.0"), new BigDecimal("12.0"));
        var expected = new BigDecimal("144.00");

        assertEquals(expected, actual, "Умножение работает не правильно!!!");
    }
}
