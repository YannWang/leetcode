package leetcode;

import java.util.*;

/**
 * Created by tech4 on 2015/6/25.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Set<String> parenSet = new HashSet<String>();
        if (n <= 0) {
            return null;
        }
        if (n == 1) parenSet.add("()");
        else {
            List<String> parenList = generateParenthesis(n - 1);
            for (String s : parenList) {
                parenSet.add(s + "()");
                parenSet.add("()" + s);
                parenSet.add("(" + s + ")");
            }
        }

        list.addAll(parenSet);
        return list;
    }

    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<String>();
        popParen(n, n, "", list);
        return list;
    }


    private void popParen(int left, int right, String s, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(s);
        }

        if (left > 0) {
            popParen(left - 1, right, s + "(", list);
        }

        if (left < right) {
            popParen(left, right - 1, s + ")", list);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(Arrays.toString(gp.generateParenthesis1(2).toArray()));
    }
}
