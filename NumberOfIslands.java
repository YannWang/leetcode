package leetcode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null) return 0;

        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '0';
                    grid = eliminateAdjacent(grid, i, j);
                }
            }
        }

        return num;
    }

    public char[][] eliminateAdjacent(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        if ((i - 1) >= 0)
            if (grid[i - 1][j] == '1') {
                grid[i - 1][j] = '0';
                grid = eliminateAdjacent(grid, i - 1, j);
            }
        if ((i + 1) <= row - 1)
            if (grid[i + 1][j] == '1') {
                grid[i + 1][j] = '0';
                grid = eliminateAdjacent(grid, i + 1, j);
            }
        if ((j - 1) >= 0)
            if (grid[i][j - 1] == '1') {
                grid[i][j - 1] = '0';
                grid = eliminateAdjacent(grid, i, j - 1);
            }
        if ((j + 1) <= column - 1)
            if (grid[i][j + 1] == '1') {
                grid[i][j + 1] = '0';
                grid = eliminateAdjacent(grid, i, j + 1);
            }

        return grid;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        NumberOfIslands ni = new NumberOfIslands();
        int num = ni.numIslands(grid);
        System.out.println(num);
    }
}
