package edu.project4;

import edu.project4.Renderers.Renderer;
import edu.project4.Transformations.Transformation;
import edu.project4.models.FractalImage;
import edu.project4.models.ImageFormat;
import edu.project4.models.Rect;
import edu.project4.task.ImageProcessor;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ImageGenerator {
    private final FractalImage fractalImage;
    private final Renderer renderer;
    private final Rect world;
    private final List<Transformation> transformations;
    private final ImageProcessor processor;

    public ImageGenerator(
        int width,
        int height,
        Renderer renderer,
        Rect world,
        List<Transformation> transformations,
        ImageProcessor processor) {
        this.fractalImage = FractalImage.create(width, height);
        this.renderer = renderer;
        this.world = world;
        this.transformations = transformations;
        this.processor = processor;
    }

    public void generate(int samples, int iterPerSample, int symmetry, Path path, ImageFormat format)
        throws IOException, InterruptedException {
        renderer.render(fractalImage, world, transformations, samples, iterPerSample, symmetry);
        processor.process(fractalImage);
        ImageUtils.save(fractalImage, path, format);
        throw new IOException();
    }
}
