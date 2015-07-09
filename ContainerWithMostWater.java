package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater {
    public int maxArea(List<Integer> heigth) {

        return 0;
    }

    //parameters: (m, am), (n, an)
    public final int calcArea(int m, int am, int n, int an) {
        if (am > an) {
            return an * (n - m);
        } else {
            return am * (n - m);
        }
    }

    public static void main(String[] args) {
        List<Integer> paraList = new ArrayList<>();
        paraList.add(1);
        paraList.add(4);
        paraList.add(4);
        paraList.add(8);
        paraList.add(4);
        System.out.println(paraList.get(3));
    }
}
