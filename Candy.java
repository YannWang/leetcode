package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tech4 on 2015/6/30.
 */
public class Candy {
    //Time Limit Exceeded.
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
        for (int candyNum : candyNums) {
            total += candyNum;
        }

        return total;
    }

    public int candy2(int[] ratings) {
        int length = ratings.length;
        if (length == 0) return 0;
        if (length == 1) return 1;
        int[] candyNums = new int[length];
        int total = 0;
        int ascending_Num = 1, descending_num = 0;

        int[] isMinimum = new int[length];
        if (ratings[0] < ratings[1]) isMinimum[0] = -1;
        if (ratings[length - 1] <= ratings[length - 2]) isMinimum[length - 1] = -1;

        for (int i = 1; i < length - 1; i++) {
            if (ratings[i] <= ratings[i - 1] && ratings[i] < ratings[i + 1]) isMinimum[i] = -1;
//            if (ratings[i])
        }

        for (int flag : isMinimum) {
            if (flag != 0) {
                descending_num++;
//                if (descending_num >= ascending_Num)
            }
        }


        boolean isAscend = true;
        boolean isFirst = true;
        for (int i = 1; i < length; i++) {
            if (isAscend) {
                if (ratings[i] >= ratings[i - 1]) {
                    ascending_Num++;
                } else {
                    isAscend = false;
                    descending_num = 1;
                }
            } else {
                if (ratings[i] <= ratings[i - 1]) {
                    descending_num++;
                } else {
                    if (descending_num > ascending_Num) {
                        total += (2 + descending_num) * (1 + descending_num) / 2;
                        if (ascending_Num != 1) {
                            total += (2 + ascending_Num) * (ascending_Num - 1) / 2;
                        }
                    }
                    if (ascending_Num >= descending_num) {
                        total += ((ascending_Num + 3) * ascending_Num + (descending_num + 1) * descending_num) / 2;
                    }
                    isAscend = true;
                    ascending_Num = 1;
                    descending_num = 0;
                }
            }

        }

        return total;
    }


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
