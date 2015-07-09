package leetcode;

/**
 * Created by tech4 on 2015/7/8.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    count++;
                }
            }
        }

    }
}
