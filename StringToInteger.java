package leetcode;

public class StringToInteger {
    @SuppressWarnings("null")
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        if (str == "") {
            return 0;
        }
        boolean flag = true;
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            str = str.substring(1);
            flag = false;
        }
        if (str == "") {
            return 0;
        }

        long res = 0;
        char c = ' ';
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c < '0' || c > '9') {
                return 0;
            } else {
                res = res * 10 + (c - '0');
            }
        }
        if (!flag) {
            res = -res;
        }
        int r = 0;
        if (res >= -2147483648 && res <= 2147483647) {
            r = (int) res;
        }

        return r;
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(myAtoi(str));
    }
}
