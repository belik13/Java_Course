package edu.project2.Generator;

import edu.project2.Maze;

public interface MazeGenerator {
    int MIN_HEIGHT = 2;
    int MIN_WIDTH = 2;

    Maze generate(int height, int width);
}
