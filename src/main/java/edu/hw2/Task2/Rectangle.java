package edu.hw2.Task2;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {

    }

    public final Rectangle setHeight(int height) {
        return new Rectangle(height, width);
    }

    public final Rectangle setWidth(int width) {
        return new Rectangle(height, width);
    }

    public double area() {
        return width * height;
    }
}
