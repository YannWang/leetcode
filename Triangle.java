package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        /*
         * Time Limited Exceeded.
         * 
         */

        int sum = Integer.MAX_VALUE;
        int len = triangle.size();
        int ll = triangle.get(len - 1).size();

        for (int i = 0; i < ll; i++) {
            int tmp = minSum(len - 1, i, triangle);
            System.out.print(tmp + "\t");
            if (sum > tmp)
                sum = tmp;
        }
        System.out.println();
        return sum;
    }

    public static int minSum(int line, int index, List<List<Integer>> triangle) {
        int sum = 0;
        List<Integer> list = triangle.get(line);
        if (line == 0) {
            return list.get(0);
        }

        if (index == 0)
            sum = minSum(line - 1, index, triangle) + list.get(index);
        else if (index == list.size() - 1)
            sum = minSum(line - 1, index - 1, triangle) + list.get(index);
        else
            sum = min(minSum(line - 1, index - 1, triangle), minSum(line - 1, index, triangle)) + list.get(index);

        return sum;
    }

    static int min(int a, int b) {
        if (a < b)
            return a;
        else return b;
    }

    public static void main(String[] args) {
        int[][] A = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                list.add(A[i][j]);
            }
            triangle.add(list);
        }

        int sum = minimumTotal(triangle);
        System.out.println("sum: " + sum);

    }
}
