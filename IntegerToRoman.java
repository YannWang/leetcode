package leetcode;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[][] signs = {units, tens, hundreds, thousands};
        String roman = "";
        String numStr = String.valueOf(num);
        int length = numStr.length();
        for (int i = 0; i < length; i++) {
            char col = numStr.charAt(length - 1 - i);

            int column = Integer.valueOf(col + "");
            String currentStr = signs[i][column];
            roman = currentStr + roman;
        }
        return roman;
    }

    public static void main(String[] args) {
        String roman = new IntegerToRoman().intToRoman(1984);
        System.out.println(roman);
    }
}
