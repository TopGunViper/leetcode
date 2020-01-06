package edu.ouc.contest66;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

/**
 * @author wqx
 */
public class _758_Bold_Words_in_String {

    /**
     * 758. Bold Words in String My SubmissionsBack to Contest
     * <p>
     * Given a set of keywords words and a string S, make all appearances of all keywords in S bold.
     * Any letters between <b> and </b> tags become bold.
     * <p>
     * The returned string should use the least number of tags possible,
     * and of course the tags should form a valid combination.
     * <p>
     * For example, given that words = ["ab", "bc"] and S = "aabcd",
     * we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags,
     * so it is incorrect.
     */
    public String boldWords(String[] words, String S) {

        boolean[] boldMark = new boolean[S.length()];

        for (int i = 0; i < words.length; i++) {
            int fromIndex = 0;
            // find all occurrence of substr
            while (fromIndex < S.length()) {
                int begin = S.indexOf(words[i], fromIndex);
                if (begin == -1) {
                    break;
                }
                int end = begin + words[i].length() - 1;
                int k = begin;
                //System.out.println("begin:" + begin + ",end:" + end);
                while (k <= end) {
                    boldMark[k++] = true;
                }
                // keywords "cc" will make S("ccc") bold.
                fromIndex = begin + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); ) {
            if (boldMark[i] == true) {
                sb.append("<b>");
                int k = i;
                while (k < S.length() && boldMark[k]) {
                    sb.append(S.charAt(k++));
                }
                sb.append("</b>");
                i = k;
            }
            if (i < S.length()) {
                sb.append(S.charAt(i++));
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String args[]) {
        //test case1
        _758_Bold_Words_in_String tester = new _758_Bold_Words_in_String();

        String[] words = {"ab", "bc"};
        String S = "aabcd";

        assertTrue(tester.boldWords(words, S).equals("a<b>abc</b>d"));

        String[] words2 = {"ab", "cb"};
        String S2 = "aabcd";

        assertTrue(tester.boldWords(words2, S2).equals("a<b>ab</b>cd"));

        String[] words3 = {"ccb", "b", "d", "cba", "dc"};
        String S3 = "eeaadadadc";
        assertTrue(tester.boldWords(words3, S3).equals("eeaa<b>d</b>a<b>d</b>a<b>dc</b>"));

        String[] words4 = {"e", "cab", "de", "cc", "db"};
        String S4 = "cbccceeead";
        assertTrue(tester.boldWords(words4, S4).equals("cb<b>ccceee</b>ad"));

        String[] words5 = {"ab", "ab"};
        String S5 = "abab";

        assertTrue(tester.boldWords(words5, S5).equals("<b>abab</b>"));

        String[] words6 = {"a", "a"};
        String S6 = "a";

        assertTrue(tester.boldWords(words6, S6).equals("<b>a</b>"));

    }
}
