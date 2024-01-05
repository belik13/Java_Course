package edu.project4.Transformations;

import edu.project4.models.Point;

public class SinusTtansformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }
}
