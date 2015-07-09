package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;
        int width = Math.min(rows, columns);

        int max = 0;
        boolean[][][] isSquare = new boolean[width + 1][rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    max = 1;
                    isSquare[1][i][j] = true;
                }
            }
        }
        if (max == 0) return 0;

        for (int w = 2; w <= width; w++) {
            for (int r = w - 1; r < rows; r++) {
                for (int c = w - 1; c < columns; c++) {
                    if (isSquare[w - 1][r][c] && isSquare[w - 1][r - 1][c] && isSquare[w - 1][r][c - 1] && isSquare[w - 1][r - 1][c - 1]) {
                        isSquare[w][r][c] = true;
                        max = w;
                    }
                }
            }
            if (max < w) break;
        }
        return max * max;
    }

    public static void main(String[] args) {
//        char[][] matrix = {"000".toCharArray(), "000".toCharArray(), "000".toCharArray(), "000".toCharArray()};
        char[][] matrix = {{}, {}};
//        char[][] matrix = {"00000".toCharArray(), "00111".toCharArray(), "10111".toCharArray(), "01011".toCharArray(), "01000".toCharArray()};
        System.out.println(maximalSquare(matrix));
    }
}
