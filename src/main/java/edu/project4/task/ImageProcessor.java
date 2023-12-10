package edu.project4.task;

import edu.project4.models.FractalImage;

@FunctionalInterface
public
interface ImageProcessor {
    void process(FractalImage image);
}
