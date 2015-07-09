package leetcode;

public class NumbersOf1Bits {
    public int hammingWeight(int n) {
        int weight = 0;
        long unsignedNumber = 0L;
        if (n >= 0) {
            unsignedNumber = n;
        } else {
            unsignedNumber = 0x0000000100000000L + n;
        }

        int bitsNum = (int) (Math.log(unsignedNumber) / Math.log(2));
        for (int i = 0; i < bitsNum + 1; i++) {
            long mask = (long) Math.pow(2, i);
            if ((mask & unsignedNumber) != 0L) {
                weight++;
            }
        }
        return weight;
    }

    public static void main(String[] args) {
        NumbersOf1Bits nb = new NumbersOf1Bits();
        System.out.println(nb.hammingWeight(11));
        System.out.println(nb.hammingWeight(1143654635));
        System.out.println(nb.hammingWeight(-1156));
        System.out.println(nb.hammingWeight(0));

    }
}
