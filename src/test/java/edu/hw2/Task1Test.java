package edu.hw2;

import java.util.stream.Stream;
import edu.hw2.Task1.Addition;
import edu.hw2.Task1.Constant;
import edu.hw2.Task1.Exponent;
import edu.hw2.Task1.Expr;
import edu.hw2.Task1.Multiplication;
import edu.hw2.Task1.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    private static Stream<Arguments> additionTest() {
        return Stream.of(
            Arguments.of(new Constant(5),new Constant(10), 15),
            Arguments.of(new Constant(-5),new Constant(10),5)
        );
    }

    private static Stream<Arguments> constantTest() {
        return Stream.of(
            Arguments.of(new Constant(5), 5),
            Arguments.of(new Constant(-5), -5)
        );
    }

    private static Stream<Arguments> exponentTest() {
        return Stream.of(
            Arguments.of(new Constant(5), 2, 25),
            Arguments.of(new Constant(2),5, 32)
        );
    }

    private static Stream<Arguments> multiplicationTest() {
        return Stream.of(
            Arguments.of(new Constant(5), new Constant(5), 25),
            Arguments.of(new Constant(2), new Constant(5), 10)
        );
    }

    private static Stream<Arguments> negateTest() {
        return Stream.of(
            Arguments.of(new Constant(5), -5),
            Arguments.of(new Constant(-2), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("constantTest")
    @DisplayName("Провекра Constant")
    public void constantCheck(Expr expr, double excepted ) {
        assertThat(expr.evaluate()).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource("additionTest")
    @DisplayName("Провекра Addition")
    public void additionCheck(Expr expr1, Expr expr2, double excepted ) {
        Expr check = new Addition(expr1,expr2);
        assertThat(check.evaluate()).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource("exponentTest")
    @DisplayName("Провекра Exponent")
    public void exponentCheck(Expr expr, int degree, double excepted) {
        Expr check = new Exponent(expr,degree);
        assertThat(check.evaluate()).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource("multiplicationTest")
    @DisplayName("Провекра Multiplication")
    public void multiplicationCheck(Expr expr1, Expr expr2, int excepted) {
        Expr check = new Multiplication(expr1,expr2);
        assertThat(check.evaluate()).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource("negateTest")
    @DisplayName("Проверка Negate")
    public void negateTest(Expr expr1, int excepted) {
        Expr check = new Negate(expr1);
        assertThat(check.evaluate()).isEqualTo(excepted);
    }
}
