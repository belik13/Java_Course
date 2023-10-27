package edu.hw2.Task1;

public sealed interface Expr permits Addition, Constant, Negate, Exponent, Multiplication {
    double evaluate();
}
