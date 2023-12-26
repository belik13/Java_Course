package edu.project2.Renderer;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.Set;

public interface MazeRenderer {

    String render(Maze maze);

    String render(Maze maze, Set<Coordinate> path);
}
