package leetcode;

/**
 * Created by tech4 on 2015/7/9.
 */
public class GasStation {
    //Time Limit Exceeded.
    //Algorithm complexity: O(n*n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas.length == 0) return -1;
        if (gas.length == 1) return 0;

        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int remainGas = 0;
            for (int j = i; j < i + length; j++) {
                remainGas += gas[j % length] - cost[j % length];
                if (remainGas < 0) break;
            }
            if (remainGas >= 0) return i;
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        return -1;
    }
}
