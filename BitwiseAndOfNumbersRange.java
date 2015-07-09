package leetcode;

public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 2147483647 & m;

        int mask = 0x40000000;
        int index = 0;
        for (int i = 30; i >= 0; i--) {
            if ((m & mask) == (n & mask)) {
                mask = mask >> 1;
            } else {
                index = i + 1;
                break;
            }
        }

        mask = 0x00000001 << index - 1;
        for (int i = index - 1; i >= 0; i--) {
            result = result & (2147483647 - mask);

            mask = mask >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        BitwiseAndOfNumbersRange br = new BitwiseAndOfNumbersRange();
        int result = br.rangeBitwiseAnd(5, 7);
        System.out.println(result);
    }
}
