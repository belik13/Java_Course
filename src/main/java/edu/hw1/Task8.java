package edu.hw1;

public class Task8 {
    private Task8() {
    }

    private static final int[][] MOVES = {
        {1, 2},
        {2, 1},
        {1, -2},
        {-2, 1},
        {-1, 2},
        {2, -1},
        {-2, -1},
        {-1, -2}
    };
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == 1) {
                    for (int[] vars : MOVES) {
                        try {
                            if (board[i + vars[0]][j + vars[1]] == 1) {
                                return false;
                            }
                        } catch (ArrayIndexOutOfBoundsException ex) {
                        }
                    }
                }
            }
        }
        return true;
    }
}
