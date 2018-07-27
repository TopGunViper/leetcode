package edu.ouc.contest90;

import org.junit.Assert;

public class _856_Score_of_Parentheses {

    public int scoreOfParentheses(String S) {
        return resolve(S);
    }

    public int resolve(String S) {
        int len = S.length();
        if (len == 0) {
            return 0;
        }
        if (len == 2) {
            return 1;
        }

        int index = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == ')') {
                left--;
            } else {
                left++;
            }

            if (left == 0) {
                index = i;
                break;
            }
        }
        if (index == 1) {
            return 1 + resolve(S.substring(2, len));
        } else if (index == len - 1) {
            return 2 * resolve(S.substring(1, index));
        } else {
            return 2 * resolve(S.substring(1, index)) + resolve(S.substring(index + 1));
        }
    }

    public static void main(String args[]) {
        _856_Score_of_Parentheses
                tester = new _856_Score_of_Parentheses();
        String S = "()";
        Assert.assertEquals(1, tester.scoreOfParentheses(S));

        String S2 = "(())";
        Assert.assertEquals(2, tester.scoreOfParentheses(S2));

        String S3 = "()()";
        Assert.assertEquals(2, tester.scoreOfParentheses(S3));

        String S4 = "(()(()))";
        Assert.assertEquals(6, tester.scoreOfParentheses(S4));

    }
}
