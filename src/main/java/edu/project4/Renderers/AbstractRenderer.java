package edu.project4.Renderers;

import edu.project4.models.AffineCoefficients;
import edu.project4.models.Pixel;
import edu.project4.models.Point;

public abstract class AbstractRenderer implements Renderer {

    public Point getRotatedPoint(Point pw, double theta) {
        double xRot = pw.x() * Math.cos(theta) - pw.y() * Math.sin(theta);
        double yRot = pw.x() * Math.sin(theta) + pw.y() * Math.cos(theta);
        return new Point(xRot, yRot);
    }

    public void setPixelColor(Pixel pixel, AffineCoefficients coefficients) {
        if (pixel.getHitCount() == 0) {
            pixel.setR(coefficients.color().getRed());
            pixel.setG(coefficients.color().getGreen());
            pixel.setB(coefficients.color().getBlue());
        } else {
            pixel.setR((pixel.getR() + coefficients.color().getRed()) / 2);
            pixel.setG((pixel.getG() + coefficients.color().getGreen()) / 2);
            pixel.setB((pixel.getB() + coefficients.color().getBlue()) / 2);
        }
    }

    public AffineCoefficients[] getRandomAffineCoefficients(int samples) {
        AffineCoefficients[] transformations = new AffineCoefficients[samples];
        for (int i = 0; i < samples; i++) {
            transformations[i] = AffineCoefficients.create();
        }
        return transformations;
    }

    public Point getPointAfterAffineTransformation(AffineCoefficients coefficients, Point pw) {
        double x = getNewXUsingCoefficients(coefficients, pw);
        double y = getNewYUsingCoefficients(coefficients, pw);
        return new Point(x, y);
    }

    public double getNewXUsingCoefficients(AffineCoefficients coefficients, Point pw) {
        return coefficients.a() * pw.x() + coefficients.b() * pw.y()
            + coefficients.c();
    }

    public double getNewYUsingCoefficients(AffineCoefficients coefficients, Point pw) {
        return coefficients.d() * pw.x() + coefficients.e() * pw.y()
            + coefficients.f();
    }
}
