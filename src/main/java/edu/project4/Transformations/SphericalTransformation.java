package edu.project4.Transformations;

import edu.project4.models.Point;

public class SphericalTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x() / (Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double y = point.y() / (Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        return new Point(x, y);
    }
}
