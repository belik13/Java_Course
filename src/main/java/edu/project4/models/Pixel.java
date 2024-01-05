package edu.project4.models;

public class Pixel {
    public int r;
    public int g;
    public int b;
    public int hitCount;
    public double normal;

    public Pixel(int r, int g, int b, int hitCount, double normal) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.hitCount = hitCount;
        this.normal = normal;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int pixel) {
        this.hitCount++;
    }

    public void setR(int pixel) {
        this.r = pixel;
    }

    public void setG(int pixel) {
        this.g = pixel;
    }

    public void setB(int pixel) {
        this.b = pixel;
    }

    public int getR() {
        return this.r;
    }

    public int getG() {
        return this.g;
    }

    public int getB() {
        return this.b;
    }

    public void setNormal(double set) {
        this.normal = set;
    }

    public double getNormal() {
        return this.normal;
    }
}
