package leetcode;

import java.util.ArrayList;

public class MinStack {
    ArrayList<Integer> list = new ArrayList<Integer>();
    private final int currentSize = 20;
    private final int addSize = 10;

    int[] num = new int[currentSize];

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = list.get(0);
        for (int ele : list) {
            if (ele < min)
                min = ele;
        }
        return min;
    }


}
