package org.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class simpleTest {

    @Test
    void additionTest() {
        assertEquals(2 + 3, 5, "2 + 3 має дорівнювати 5");
    }
}

