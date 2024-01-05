package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Task6Test {
    @Test
    @DisplayName("scanPorts Test")
    void scanPortsTest() {
        assertDoesNotThrow(Task6::scanPorts);
    }
}
