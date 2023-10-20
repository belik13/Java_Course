package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    @DisplayName("ExampleTest")
    public void exampleTest(Rectangle rect) {
        Rectangle rectangle = rect.setWidth(20);
        Rectangle check = rectangle.setHeight(10);
        assertThat(check.area()).isEqualTo(200.0);
    }
    @Test
    @DisplayName("Создание прямоугольника из квадрата")
    public void creatingRectangle() {
        Square check = new Square(7).setLength(4);
        assertThat(check.area()).isEqualTo(16);
    }
    @Test
    @DisplayName("Создание квадрата из прямоугольника")
    public void creatingSquare() {
        Rectangle check = new Rectangle(5, 10)
            .setHeight(5)
            .setWidth(5);
        assertThat(check.area()).isEqualTo(25);
    }
}
