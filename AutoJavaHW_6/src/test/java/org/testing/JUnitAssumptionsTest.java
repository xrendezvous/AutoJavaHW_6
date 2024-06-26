package org.testing;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitAssumptionsTest {

    @BeforeEach
    public void setUp() {
        Assumptions.assumeTrue(System.getProperty("java.version").startsWith("17"), "Пропускаємо тестування, якщо версія Java не 17");
    }

    @Test
    public void simpleTest() {
        String actual = "Hello, world!";
        String expected = "Hello, world!";
        Assumptions.assumeTrue(actual != null, "Пропускаємо тестування, якщо actual null");
        assertEquals(expected, actual, "Тест пройшов успішно");
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "madam" })
    public void paramTest(String candidate) {
        Assumptions.assumeTrue(candidate.length() > 0, "Пропускаємо тестування, якщо строка порожня");
        assertEquals(candidate, new StringBuilder(candidate).reverse().toString(), "Строка є паліндромом");
    }
}

