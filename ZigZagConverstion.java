package leetcode;

public class ZigZagConverstion {
    public static String convert(String s, int nRows) {
        if (s == null) return s;
        if (s == "" || nRows <= 1) return s;
        StringBuilder[] zigzag = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            zigzag[i] = new StringBuilder("");
        }

        //consider two rows
        if (nRows == 2) {
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    zigzag[0] = zigzag[0].append(s.charAt(i));
                } else {
                    zigzag[1] = zigzag[1].append(s.charAt(i));
                }
            }
            return zigzag[0].append(zigzag[1]).toString();
        }

        //more than two rows
        int num = 2 * nRows - 2;
        int unit = s.length() / num;
        for (int i = 0; i < unit; i++) {
            zigzag[0] = zigzag[0].append(s.charAt(i * num));
            for (int j = 1; j < nRows - 1; j++) {
                zigzag[j] = zigzag[j].append(s.charAt(i * num + j)).append(s.charAt(i * num + 2 * nRows - j - 2));
            }
            zigzag[nRows - 1] = zigzag[nRows - 1].append(s.charAt(i * num + nRows - 1));
        }
        int row = 0;
        boolean flag = true;
        for (int i = unit * num; i < s.length(); i++) {
            if (flag) {
                zigzag[row] = zigzag[row].append(s.charAt(i));
                row++;
                if (row == nRows - 1) flag = false;
            } else {
                zigzag[row] = zigzag[row].append(s.charAt(i));
                row--;
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < nRows; i++) {
            sb = sb.append(zigzag[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "paypalishiring";
        int nRows = 3;
        String retStr = convert(s, nRows);
        System.out.println(retStr);
    }
}
