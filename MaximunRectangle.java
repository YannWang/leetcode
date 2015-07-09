package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class MaximunRectangle {
    //wrong solution
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;
        int maxArea = 0;
        boolean[][][][] isRect = new boolean[rows + 1][columns + 1][rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    isRect[1][1][i][j] = true;
                    maxArea = 1;
                }
            }
        }

        for (int h = 1; h <= rows; h++) {
            for (int w = 1; w <= columns; w++) {
                for (int r = h - 1; r < rows; r++) {
                    for (int c = w - 1; c < columns; c++) {
//                        if (isRect[h-1][w][r-1][c] && isRect[1][w][r][c])
                    }
                }

            }

        }
        return maxArea;
    }

    public static int maximalRectangle2(char[][] matrix) {
        if (matrix == null) return 0;
        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;

        int[] left = new int[columns];
        int[] right = new int[columns];
        int[] height = new int[columns];
        for (int i = 0; i < columns; i++) {
            right[i] = columns;
        }

        int maxArea = 0;
        for (char[] aMatrix : matrix) {
            int currentLeft = 0, currentRight = columns;

            for (int j = 0; j < columns; j++) {
                if (aMatrix[j] == '1') {
                    left[j] = Math.max(left[j], currentLeft);
                    height[j]++;
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = columns;
                    currentLeft = j + 1;
                }
            }

            for (int j = columns - 1; j >= 0; j--) {
                if (aMatrix[j] == '1') {
                    right[j] = Math.min(right[j], currentRight);
                    maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
                } else {
                    currentRight = j;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {"100100".toCharArray(), "000111".toCharArray(), "111111".toCharArray(), "011111".toCharArray()};
        System.out.println(maximalRectangle2(matrix));
    }
}
