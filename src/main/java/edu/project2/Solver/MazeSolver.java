package edu.project2.Solver;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.Set;

public interface MazeSolver {
    Set<Coordinate> findPath(
        Maze maze,
        Coordinate start,
        Coordinate end
    );
}
