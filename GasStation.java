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

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas.length == 0 || gas.length != cost.length) {
            return -1;
        }
        if (gas.length == 1) {
            return 0;
        }
        int start = 0, end = 1;
        int remainGas = gas[0] + cost[0];


        while (start != end) {
            if (remainGas < 0) {
                start = (start - 1) % gas.length;
                remainGas += gas[start] - cost[start];
            } else {
                remainGas += gas[end] - cost[end];
                end = (end + 1) % gas.length;
            }
        }
        if (remainGas >= 0) return start;
        else return -1;
    }

    public static void main(String[] args) {
        int[] gas = {5, 0, 9, 4, 3, 3, 9, 9, 1, 2};
        int[] cost = {6, 7, 5, 9, 5, 8, 7, 1, 10, 5};
        System.out.println(canCompleteCircuit2(gas, cost));
    }
}
