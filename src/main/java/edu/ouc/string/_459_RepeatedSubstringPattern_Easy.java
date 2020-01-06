package edu.ouc.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 459. Repeated Substring Pattern
 * <p>
 * Given a non-empty string check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together. You may assume the given
 * string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * @see <a href="https://leetcode.com/problems/repeated-substring-pattern/">Repeated Substring Pattern</a>
 */
public class _459_RepeatedSubstringPattern_Easy {
    public static void main(String[] args) {
        _459_RepeatedSubstringPattern_Easy solution = new _459_RepeatedSubstringPattern_Easy();
        String s = "abab";
        assertTrue(solution.repeatedSubstringPattern(s));
        s = "aba";
        assertFalse(solution.repeatedSubstringPattern(s));
        s = "abcabcabcabc";
        assertTrue(solution.repeatedSubstringPattern(s));
        s = "ababab";
        assertTrue(solution.repeatedSubstringPattern(s));

    }

    public boolean repeatedSubstringPattern(String s) {

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) {
                continue;
            }
            int r = s.length() / i;
            String subStr = s.substring(0, i);
            StringBuilder sb = new StringBuilder(s.length());
            while (r-- > 0) {
                sb.append(subStr);
            }
            if (sb.toString().equals(s)) {
                return true;
            }

        }
        return false;
    }

}
