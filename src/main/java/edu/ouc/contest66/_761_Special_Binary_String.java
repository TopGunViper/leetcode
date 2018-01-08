package edu.ouc.contest66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.tools.javac.util.Assert;

/**
 * 761. Special Binary String My SubmissionsBack to Contest
 * User Accepted: 64
 * User Tried: 184
 * Total Accepted: 65
 * Total Submissions: 554
 * Difficulty: Hard
 * Special binary strings are binary strings with the following two properties:
 * <p>
 * The number of 0's is equal to the number of 1's.
 * Every prefix of the binary string has at least as many 1's as 0's.
 * Given a special string S, a move consists of choosing two consecutive, non-empty,
 * special substrings of S, and swapping them. (Two strings are consecutive if the last
 * character of the first string is exactly one index before the first character of the
 * second string.)
 * <p>
 * At the end of any number of moves, what is the lexicographically largest resulting string
 * possible?
 * <p>
 * Input: S = "11011000"
 * Output: "11100100"
 *
 * @author wqx
 */
public class _761_Special_Binary_String {

    /**
     * Solution:
     * The worst solution!!! But i don't have any other better idea!!!
     *
     * @param S binary strings
     *
     * @return largest string lexicographically
     */
    public String makeLargestSpecial(String S) {
        if (S.length() == 0) {
            return "";
        }
        String res = S;
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                String cur = S.substring(i, j);
                if (isSpecial(cur)) {
                    for (int k = j + 1; k <= S.length(); k++) {
                        String sec = S.substring(j, k);
                        if (!sec.equals(cur) && isSpecial(sec)) {
                            String str = swapStr(S, i, j - 1, j, k - 1);
                            if (str.compareTo(res) > 0) {
                                res = str;
                            }
                        }
                    }
                }
            }
        }
        // During one round iteration, two swapped str is consecutive, so, we
        // need step further, trigger another iteration.
        if (res.equals(S)) {
            return res;
        } else {
            return makeLargestSpecial(res);
        }
    }

    public String swapStr(String s, int p1, int p2, int p3, int p4) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, p1))
                .append(s.substring(p3, p4 + 1))
                .append(s.substring(p1, p2 + 1))
                .append(s.substring(p4 + 1, s.length()));
        return sb.toString();
    }

    public boolean isSpecial(String S) {
        if (S.startsWith("0")) {
            return false;
        }
        int k = 0;
        int count = 0;
        while (k < S.length()) {
            count += (S.charAt(k++) == '1' ? 1 : -1);
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String args[]) {
        //test case1
        _761_Special_Binary_String tester = new _761_Special_Binary_String();
        System.out.println(tester.isSpecial("1"));
        String S = "11011000";

        //Assert.check(tester.makeLargestSpecial2(S).equals("11100100"));

        S = "101100101100";
        Assert.check(tester.makeLargestSpecial2(S).equals("110011001010"));
    }

    public String makeLargestSpecial2(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                System.out.println("S.substring(i + 1, j):" + S.substring(i + 1, j));
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                i = j + 1;
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}
