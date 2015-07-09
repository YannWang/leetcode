package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }

}
