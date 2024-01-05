package edu.project4.models;

public record FractalImage(Pixel[][] data, int height, int width) {
    public static FractalImage create(int width, int height) {
        Pixel[][] data = new Pixel[height][width];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        return new FractalImage(data, height, width);
    }

    boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Pixel getPixel(int x, int y) {
        if (!contains(x, y)) {
            return null;
        }
        return data[y][x];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
