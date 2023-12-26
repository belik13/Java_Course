package edu.project2.Solver;

import edu.project2.SolverName;

public class MazeSolverFactory {

    public MazeSolver getMazeSolver(SolverName solver) {
        return switch (solver) {
            case BFS -> new BFSMazeSolver();
            case DFS -> new DFSMazeSolver();
            case WAVE -> new WaveMazeSolver();

        };
    }
}
