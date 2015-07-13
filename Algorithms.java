package leetcode;

import java.util.Arrays;

/**
 * Created by tech4 on 2015/7/9.
 */
public class Algorithms {
    public static void quickSort(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private static void qSort(int[] nums, int a, int b) {
        if (a >= b) return;

        int left = a;
        int right = b;
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        qSort(nums, a, left - 1);
        qSort(nums, left + 1, b);
    }

    /**
     * 来源于《计算机算法基础》（余祥宣版）5.3.1节
     * 带有限期和效益的单位时间的作业排序贪心算法
     * 作业已按受益排序
     *
     * @param D: 按收益排序的作业所需要消耗的时间的数组
     * return : 按调度顺序排列的数组,作业序号为1...n，不是由0开始
     */
    public static int[] JS(int[] D) {
        int jobs = D.length;
        int[] retJ = new int[jobs];
        if (jobs == 0) return retJ;
        if (jobs == 1) {
            if (D[0] < 1) return new int[0];
            else {
                retJ[0] = 1;
                return retJ;
            }
        }

        //添加哨兵
        int[] J = new int[jobs + 1];
        int[] extdD = new int[jobs + 1];
        System.arraycopy(D, 0, extdD, 1, jobs);
        J[1] = 1;

        int k = 1;
        for (int i = 2; i <= jobs; i++) {
            int r = k;
            while (extdD[J[r]] > extdD[i] && extdD[J[r]] != r) {
                r--;
            }
            if (extdD[J[r]] <= extdD[i] && extdD[i] > r) {
                System.arraycopy(J, r + 1, J, r + 1 + 1, k + 1 - (r + 1));
                J[r + 1] = i;
                k++;
            }
        }

        int[] acceptedJobs = new int[k];
        System.arraycopy(J, 1, acceptedJobs, 0, k);
        return acceptedJobs;
    }

    /**
     * 带期限的作业排序，《计算机算法基础》5.3.1节
     * 给出收益和截止期限，要求接受作业的收益最大,返回最大收益。
     *
     * @param profits:作业收益.
     * @param delay:        作业可接受的延迟时间
     */
    public static int greedyJob(int[] profits, int[] delay) {
        if (profits.length == 0) return 0;
        int[] index = new int[profits.length];

        class Triple {
            int index;
            int profits;
            int delay;

            public Triple(int a, int b, int c) {
                index = a;
                profits = b;
                delay = c;
            }

            public String toString() {
                return "[" + index + ", " + profits + ", " + delay + "]";
            }
        }

        Triple[] triples = new Triple[profits.length];
        for (int i = 0; i < profits.length; i++) {
            triples[i] = new Triple(i, profits[i], delay[i]);
        }
        Arrays.sort(triples, (o1, o2) -> {
            int num1 = o1.profits;
            int num2 = o2.profits;
            if (num1 < num2) return 1;
            else if (num1 == num2) return 0;
            else return -1;
        });

        for (int i = 0; i < profits.length - 1; i++) {
            delay[i] = triples[i].delay;
        }
        int[] accepted = JS(delay);

        int maxProfits = 0;
        for (int anAccepted : accepted) {
            maxProfits += triples[anAccepted - 1].profits;
        }
        return maxProfits;
    }

    public static void main(String[] args) {
//        int[] profits = {100, 10, 15, 20};
//        int[] delay = {2, 1, 2, 1};
        int[] profits = {20, 15, 10, 5, 1};
        int[] delay = {2, 2, 1, 3, 3};
        System.out.println("Return accepted array: " + Arrays.toString(JS(delay)));
        System.out.println("Max profits is: " + greedyJob(profits, delay));
    }
}
