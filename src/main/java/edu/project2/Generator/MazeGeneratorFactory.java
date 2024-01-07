package edu.project2.Generator;

import edu.project2.GeneratorName;

public class MazeGeneratorFactory {

    public MazeGenerator getMazeGenerator(GeneratorName generator) {
        return switch (generator) {
            case PRIM -> new PrimMazeGenerator();

        };
    }
}
