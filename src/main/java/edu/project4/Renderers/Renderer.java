package edu.project4.Renderers;

import edu.project4.Transformations.Transformation;
import edu.project4.models.FractalImage;
import edu.project4.models.Rect;
import java.util.List;

public interface Renderer {

    FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> transformations,
        int samples,
        int iterPerSample,
        int symmetry
    ) throws InterruptedException;
}
