package edu.hw2.Task1;

public record Exponent(Expr expr1, double degree) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(expr1.evaluate(), degree);
    }
}
