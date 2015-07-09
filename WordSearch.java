package leetcode;

/**
 * Created by tech4 on 2015/7/8.
 */
public class WordSearch {
    public static boolean exists(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length()) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (visited[x][y]) return false;
        if (board[x][y] != word.charAt(index)) return false;
        visited[x][y] = true;
        boolean ret = dfs(board, word, index + 1, x - 1, y, visited) ||
                dfs(board, word, index + 1, x + 1, y, visited) ||
                dfs(board, word, index + 1, x, y - 1, visited) ||
                dfs(board, word, index + 1, x, y + 1, visited);
        visited[x][y] = false;
        return ret;
    }

    public static void main(String[] args) {
        char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
//        String s = "ABCCED";
//        String s = "SEE";
        String s = "ABCB";
        System.out.println(exists(board, s));
    }
}
