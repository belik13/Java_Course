package edu.project4.Renderers;

import edu.project4.Transformations.Transformation;
import edu.project4.models.AffineCoefficients;
import edu.project4.models.FractalImage;
import edu.project4.models.Pixel;
import edu.project4.models.Point;
import edu.project4.models.Rect;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MultiThread extends AbstractRenderer  {
    private static final int NUMBER_OF_THREADS = 10;
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static final int START = -20;

    public FractalImage render(
        FractalImage canvas, Rect world, List<Transformation> transformations,
        int samples, int iterPerSample, int symmetry
    ) throws InterruptedException {
        AffineCoefficients[] coefficientsArray = getRandomAffineCoefficients(samples);
        for (int num = 0; num < samples; num++) {
            executorService.execute(() -> executeIterations(
                canvas,
                world,
                iterPerSample,
                symmetry,
                transformations,
                coefficientsArray
            ));
        }
        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        return canvas;
    }

    private void executeIterations(
        FractalImage canvas,
        Rect world,
        int iterPerSample,
        int symmetry,
        List<Transformation> transformations,
        AffineCoefficients[] coefficientsArray) {
        Point pw = world.getRandomPoint();
        for (int step = START; step < iterPerSample; step++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, coefficientsArray.length);
            AffineCoefficients coefficients = coefficientsArray[randomIndex];
            pw = getPointAfterAffineTransformation(coefficients, pw);
            Transformation transformation =
                transformations.get(ThreadLocalRandom.current().nextInt(0, transformations.size()));
            pw = transformation.apply(pw);
            if (step >= 0) {
                double theta = 0;
                for (int s = 0; s < symmetry; s++) {
                    theta += 2 * Math.PI / symmetry;
                    Point pwr = getRotatedPoint(pw, theta);
                    if (!world.doesContainPoint(pwr)) {
                        continue;
                    }
                    Pixel pixel =
                        canvas.getPixel(
                            (int)
                                ((pwr.x() - world.x()) * canvas.getWidth() / world.width()),
                            (int) ((pwr.y() - world.y()) * canvas.getHeight() / world.height())
                        );
                    if (pixel == null) {
                        continue;
                    }
                    synchronized (pixel) {
                        setPixelColor(pixel, coefficients);
                        pixel.setHitCount(pixel.getHitCount() + 1);
                    }
                }
            }
        }
    }
}
