package org.testing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    void testWithAssertJ() {
        String str = "Hello, world!";
        assertThat(str).isNotBlank()
                .contains("world")
                .startsWith("Hello")
                .endsWith("!");
    }
}

