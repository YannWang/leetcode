package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tech4 on 2015/6/30.
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        int[] candyNums = new int[ratings.length];
        candyNums[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candyNums[i] = candyNums[i - 1] + 1;
            else if (ratings[i] == ratings[i - 1]) candyNums[i] = candyNums[i - 1];
            else {
                candyNums[i] = 1;
                int j = i;
                while (j - 1 >= 0 && ratings[j] < ratings[j - 1] && candyNums[j] == candyNums[j - 1]) {
                    candyNums[j - 1]++;
                    j--;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < candyNums.length; i++) {
            total += candyNums[i];
        }

        return total;
    }

//    public int candy2(int[] ratings) {
//        int[] candyNums = new int[ratings.length];
//
//    }


    public static void main(String[] args) {
        int[] ratings = new int[10];
        Random rnd = new Random(47);
        for (int i = 0; i < ratings.length; i++) {
            ratings[i] = rnd.nextInt(10);
        }
        System.out.println(Arrays.toString(ratings));
        System.out.println(new Candy().candy(ratings));
    }
}
