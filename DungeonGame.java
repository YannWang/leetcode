package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class DungeonGame {
    //wrong answer
    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;

        int[][] initialHP = new int[rows][columns];
        int[][] remainHP = new int[rows][columns];

        if (dungeon[0][0] >= 0) {
            initialHP[0][0] = 1;
            remainHP[0][0] = dungeon[0][0] + 1;
        } else {
            initialHP[0][0] = -dungeon[0][0] + 1;
            remainHP[0][0] = 1;
        }

        for (int i = 1; i < columns; i++) {
            int mn = remainHP[0][i - 1] + dungeon[0][i];
            if (mn > 0) {
                initialHP[0][i] = initialHP[0][i - 1];
                remainHP[0][i] = mn;
            } else {
                initialHP[0][i] = initialHP[0][i - 1] - mn + 1;
                remainHP[0][i] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            int mn = remainHP[i - 1][0] + dungeon[i][0];
            if (mn > 0) {
                initialHP[i][0] = initialHP[i - 1][0];
                remainHP[i][0] = mn;
            } else {
                initialHP[i][0] = initialHP[i - 1][0] - mn + 1;
                remainHP[i][0] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int tmpInitial1, tmpInitial2;
                int tmpRemain1, tmpRemain2;

                int mn = remainHP[i][j - 1] + dungeon[i][j];
                if (mn > 0) {
                    tmpInitial1 = initialHP[i][j - 1];
                    tmpRemain1 = mn;
                } else {
                    tmpInitial1 = initialHP[i][j - 1] - mn + 1;
                    tmpRemain1 = 1;
                }

                mn = remainHP[i - 1][j] + dungeon[i][j];
                if (mn > 0) {
                    tmpInitial2 = initialHP[i - 1][j];
                    tmpRemain2 = mn;
                } else {
                    tmpInitial2 = initialHP[i - 1][j] - mn + 1;
                    tmpRemain2 = 1;
                }

                if (tmpInitial1 < tmpInitial2) {
                    initialHP[i][j] = tmpInitial1;
                    remainHP[i][j] = tmpRemain1;
                } else if (tmpInitial1 > tmpInitial2) {
                    initialHP[i][j] = tmpInitial2;
                    remainHP[i][j] = tmpRemain2;
                } else {
                    initialHP[i][j] = tmpInitial1;
                    remainHP[i][j] = Math.max(tmpRemain1, tmpRemain2);
                }
            }
        }

        return initialHP[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
//        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] dungeon = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
