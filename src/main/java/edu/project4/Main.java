package edu.project4;

import edu.project4.Renderers.MultiThread;
import edu.project4.Transformations.HeartTransformation;
import edu.project4.Transformations.SphericalTransformation;
import edu.project4.models.ImageFormat;
import edu.project4.models.Rect;
import edu.project4.task.GammaCorrImageProcessor;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private Main() {

    }

    private static final int ONE_HUNDREAD = 100;
    private static final int HUNDREAD_THOUSANDS = 100000;

    public static void main(String[] args) throws IOException, InterruptedException {
        Path file = Path.of("C:\\Users\\bmaks\\Desktop\\Tinkoff-Course\\newfile.png");
        @SuppressWarnings("MagicNumber")
        ImageGenerator imageGenerator = new ImageGenerator(1920, 1080, new MultiThread(),
            new Rect(-4, -3, 8, 6),
            List.of(new SphericalTransformation(), new HeartTransformation()), new GammaCorrImageProcessor());
        imageGenerator.generate(100, 1000000, 2, file, ImageFormat.PNG);
    }
}
