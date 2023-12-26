package edu.project2.Solver;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import static java.util.Collections.emptySet;

public class WaveMazeSolver implements MazeSolver {

    public WaveMazeSolver() {
    }

    public Set<Coordinate> findPath(Maze maze, Coordinate start, Coordinate end) {

        int[][] distances = new int[maze.getHeight()][maze.getWidth()];
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                distances[i][j] = -1;
            }
        }

        queue.add(start);
        distances[start.row()][start.col()] = 0;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            List<Coordinate> neighbors = maze.getNeighbors(current);

            for (Coordinate neighbor : neighbors) {
                if (distances[neighbor.row()][neighbor.col()] == -1) {

                    distances[neighbor.row()][neighbor.col()]
                        = distances[current.row()][current.col()] + 1;

                    queue.add(neighbor);
                }
            }
        }

        Set<Coordinate> path = new HashSet<>();
        Coordinate current = end;
        path.add(current);

        while (!current.equals(start)) {
            List<Coordinate> neighbors = maze.getNeighbors(current);

            int cnt = 0;
            for (Coordinate neighbor : neighbors) {
                if (distances[neighbor.row()][neighbor.col()]
                    == distances[current.row()][current.col()] - 1) {

                    cnt++;
                    current = neighbor;
                    path.add(current);
                    break;
                }
            }

            if (cnt == 0) {
                return emptySet();
            }
        }

        return path;
    }

}
