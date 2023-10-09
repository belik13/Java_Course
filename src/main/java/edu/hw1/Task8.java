package edu.hw1;

public class Task8 {
    private Task8() {
    }

    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    public static final int BOARD_CHECK = 7;

    public static boolean checkMoves(int i, int j, int[][] board) {
        return move1(board, i, j) || move2(board, i, j)
            || move3(board, i, j) || move4(board, i, j)
            || move5(board, i, j) || move6(board, i, j)
            || move7(board, i, j) || move8(board, i, j);
    }

    public static boolean move1(int[][] board, int i, int j) {
        if (i - 2 >= 0 && j - 1 >= 0) {
            return board[i - 2][j - 1] == 1;
        }
        return false;
    }

    public static boolean move2(int[][] board, int i, int j) {
        if (i - 2 >= 0 && j + 1 <= BOARD_CHECK) {
            return board[i - 2][j + 1] == 1;
        }
        return false;
    }

    public static boolean move3(int[][] board, int i, int j) {
        if (i + 2 <= BOARD_CHECK && j - 1 >= 0) {
            return board[i + 2][j - 1] == 1;
        }
        return false;
    }

    public static boolean move4(int[][] board, int i, int j) {
        if (i + 2 <= BOARD_CHECK && j + 1 <= BOARD_CHECK) {
            return board[i + 2][j + 1] == 1;
        }
        return false;
    }

    public static boolean move5(int[][] board, int i, int j) {
        if (i - 1 >= 0 && j - 2 >= 0) {
            return board[i - 1][j - 2] == 1;
        }
        return false;
    }

    public static boolean move6(int[][] board, int i, int j) {
        if (i - 1 >= 0 && j + 2 <= BOARD_CHECK) {
            return board[i - 1][j + 2] == 1;
        }
        return false;
    }

    public static boolean move7(int[][] board, int i, int j) {
        if (j - 2 >= 0 && i + 1 <= BOARD_CHECK) {
            return board[i + 1][j - 2] == 1;
        }
        return false;
    }

    public static boolean move8(int[][] board, int i, int j) {
        if (i + 1 <= BOARD_CHECK && j + 2 <= BOARD_CHECK) {
            return board[i + 1][j + 2] == 1;
        }
        return false;
    }

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == 1) {
                    if (checkMoves(i, j, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
