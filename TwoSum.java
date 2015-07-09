package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int len = numbers.length;
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < len; i++) {
            numMap.put(i + 1, numbers[i]);
        }
        ArrayList<Map.Entry<Integer, Integer>> numList = new ArrayList<Map.Entry<Integer, Integer>>(
                numMap.entrySet());

        Collections.sort(numList,
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> o1,
                                       Map.Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });

        int start = 0;
        int end = len - 1;
        while (start < end) {
            int small = numList.get(start).getValue();
            int big = numList.get(end).getValue();
            if (small + big < target)
                start++;
            else if (small + big > target)
                end--;
            else {
                index[0] = numList.get(start).getKey();
                index[1] = numList.get(end).getKey();
                if (index[0] > index[1]) {
                    index[0] = index[0] + index[1];
                    index[1] = index[0] - index[1];
                    index[0] = index[0] - index[1];
                }
                return index;
            }
        }

        return index;
    }

    int[] quickSort(int[] numbers) {
        int len = numbers.length;
        int pivot = numbers[0];
        int i = 0, j = len - 1;

        while (i < j) {
            if (numbers[i] > pivot) {
                int[] r = switchNums(numbers[i], numbers[j]);
                numbers[i] = r[0];
                numbers[j] = r[1];
            }
            j--;

            if (numbers[j] < pivot) {
                int[] r = switchNums(numbers[i], numbers[j]);
                numbers[i] = r[0];
                numbers[j] = r[1];
            }
            i--;
        }
        return numbers;
    }

    int[] twoSum_v2(int[] numbers, int target) {
        int[] index = new int[]{-1, -1};

        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = (i + 1); j < len; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum == target) {
                    index[0] = i + 1;
                    index[1] = j + 1;
                    return index;
                }
            }
        }

        return index;
    }

    int[] switchNums(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        int[] result = {a, b};

        return result;
    }

    public int[] twoSum_V3(int[] numbers, int target) {
        int[] index = new int[2];
        int len = numbers.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < len; i++) {
            int num = numbers[i];
            ArrayList<Integer> list = new ArrayList<Integer>();

            if (map.containsKey(num))
                list = map.get(num);
            list.add(i);
            map.put(num, list);
        }

        for (int i = 0; i < len; i++) {
            int other = target - numbers[i];
            if (map.containsKey(other)) {
                ArrayList<Integer> iList = map.get(other);
                for (int indx : iList) {
                    if (i != indx) {
                        if (i > indx) {

                        }

                    }
                }

            }
        }

        return index;
    }

    public int[] towSum_V4(int[] numbers, int target) {
        int[] indices = new int[2];
        int len = numbers.length;
        if (len <= 1)
            return indices;

        Map<Integer, Integer> numSet = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (numSet.get(target - numbers[i]) != null) {
                indices[0] = numSet.get(target - numbers[i]) + 1;
                indices[1] = i + 1;
            } else {
                numSet.put(numbers[i], i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] numbers = {4, 6, 9, 2, 0, 5, 3, 5};
        int target = 9;
        int[] index2 = ts.twoSum_v2(numbers, target);
        System.out.println("index2 1: " + index2[0] + ", index2 2: "
                + index2[1]);

        int[] index = ts.twoSum(numbers, target);
        System.out.println("index 1: " + index[0] + ", index 2: " + index[1]);
    }
}
