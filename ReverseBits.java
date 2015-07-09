package leetcode;

public class ReverseBits {
    public int reverseBits(int n) {
        int reverseResult = 0;

        int[] mask = new int[32];
        mask[0] = 1;
        for (int i = 1; i < 31; i++) {
            mask[i] = mask[i - 1] * 2;
        }
        mask[31] = -mask[30] * 2;
        for (int i = 0; i <= 31; i++) {
            int p = 31 - i;
            if (p > i) {
                reverseResult = ((n << (p - i)) & mask[p]) | reverseResult;
            } else {
                reverseResult = ((n >> (i - p)) & mask[p]) | reverseResult;
            }
        }

        return reverseResult;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(-2147483648));
        System.out.println(rb.reverseBits(-1));
        System.out.println(rb.reverseBits(2));
    }
}
