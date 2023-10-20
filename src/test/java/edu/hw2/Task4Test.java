package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Тест на CallingInfo")
    public void testCheckMethod() {
        CallingInfo record = CallingInfo.callingInfo();
        assertEquals(record.className(), "edu.hw2.Task4Test");
        assertEquals(record.methodName(), "testCheckMethod");
    }
}
