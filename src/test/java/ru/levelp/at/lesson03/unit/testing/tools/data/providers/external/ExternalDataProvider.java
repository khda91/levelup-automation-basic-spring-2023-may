package ru.levelp.at.lesson03.unit.testing.tools.data.providers.external;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ExternalDataProvider {

    static Stream<Arguments> addDataProvider() {
        return Stream.of(
            Arguments.of(new BigDecimal("12.0"), new BigDecimal("12.0"), new BigDecimal("24.0")),
            Arguments.of(new BigDecimal("1.0"), new BigDecimal("12.0"), new BigDecimal("13.0")),
            Arguments.of(new BigDecimal("5.0"), new BigDecimal("0.5"), new BigDecimal("5.5"))
        );
    }

    static Stream<Arguments> multiplyDataProvider() {
        return Stream.of(
            Arguments.of(new BigDecimal("12.0"), new BigDecimal("12.0"), new BigDecimal("144.00")),
            Arguments.of(new BigDecimal("1.0"), new BigDecimal("12.0"), new BigDecimal("12.00")),
            Arguments.of(new BigDecimal("5.0"), new BigDecimal("0.5"), new BigDecimal("2.50"))
        );
    }
}
