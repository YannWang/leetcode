package leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int index1, index2;
        if ((m + n) % 2 == 0) {
            index1 = (m + n) / 2;
            index2 = index1 + 1;
        } else {
            index1 = index2 = (m + n) / 2 + 1;
        }
        double num1 = 0;
        double num2 = 0;

        int indexA, indexB, count;
        indexA = indexB = count = 0;
        int currentNum = 0;
        boolean flag = true;
        while (indexA < m && indexB < n) {
            if (A[indexA] <= B[indexB]) {
                currentNum = A[indexA];
                indexA++;
                count++;
            } else {
                currentNum = B[indexB];
                indexB++;
                count++;
            }
            if (count == index1) {
                num1 = currentNum;
            }
            if (count == index2) {
                num2 = currentNum;
                flag = false;
                break;
            }
        }

        if (flag) {
            while (indexA < m) {
                currentNum = A[indexA];
                indexA++;
                count++;
                if (count == index1) {
                    num1 = currentNum;
                }
                if (count == index2) {
                    num2 = currentNum;
                    break;
                }
            }
            while (indexB < n) {
                currentNum = B[indexB];
                indexB++;
                count++;
                if (count == index1) {
                    num1 = currentNum;
                }
                if (count == index2) {
                    num2 = currentNum;
                    break;
                }
            }
        }

        return (num1 + num2) / 2;
    }
}
