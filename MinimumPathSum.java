package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 1; i < columns; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[rows - 1][columns - 1];
    }
}
