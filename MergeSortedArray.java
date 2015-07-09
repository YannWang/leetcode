package leetcode;

public class MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        while (m != 0 && n != 0) {
            if (A[m - 1] >= B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        while (n != 0) {
            A[m + n - 1] = B[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 4;
        A[1] = 5;
        A[2] = 6;

        int[] B = {1, 2, 3};

        new MergeSortedArray().merge(A, 3, B, 3);
        for (int i = 0; i < 9; i++) {
            System.out.print(A[i] + "\t");
        }
    }
}
