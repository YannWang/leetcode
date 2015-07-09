package leetcode;

/**
 * Created by tech4 on 2015/6/26.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean isPositive = true;
        if (dividend < 0) isPositive = !isPositive;
        if (divisor < 0) isPositive = !isPositive;

        long dd = dividend;
        dd = Math.abs(dd);
        long dr = divisor;
        dr = Math.abs(dr);

        long quotient = divideLong(dd, dr);

        if (isPositive && quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (!isPositive && quotient > (long) Integer.MAX_VALUE + 1L) return Integer.MAX_VALUE;

        return isPositive ? (int) quotient : (int) (-quotient);
    }

    private long divideLong(long dd, long dr) {
        if (dd < dr) return 0;
        long quotient = 1;
        long d = dd - dr;

        while (d > (dd - d)) {
            d = d + d - dd;
            quotient += quotient;
        }

        return quotient + divideLong(d, dr);
    }
}
