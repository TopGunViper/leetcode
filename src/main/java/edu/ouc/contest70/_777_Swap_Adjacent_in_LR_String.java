package edu.ouc.contest70;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _777_Swap_Adjacent_in_LR_String {

    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray(), e = end.toCharArray();
        int n = s.length, next = 1;
        for (int i = 0; i < n; i++) {
            if (s[i] == e[i]) {
                continue;
            }
            if ((e[i] == 'stepX' && s[i] == 'R') || (e[i] == 'L' && s[i] == 'stepX')) {
                next = Math.max(next, i + 1);
                while (next < n && s[next] == s[i]) {
                    next++;
                }
                if (next == n || s[next] != e[i]) {
                    return false;
                }
                s[next] = s[i];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        //test case1
        _777_Swap_Adjacent_in_LR_String tester = new _777_Swap_Adjacent_in_LR_String();
        String start = "RXXLRXRXL", end = "XRLXXRRLX";

        Assert.assertTrue(tester.canTransform(start, end));

        String start2 = "stepX", end2 = "L";

        Assert.assertFalse(tester.canTransform(start2, end2));

        String start3 = "stepX", end3 = "stepX";

        Assert.assertTrue(tester.canTransform(start3, end3));

        String start4 = "XXXXXLXXXX";
        String end4 = "LXXXXXXXXX";
        Assert.assertTrue(tester.canTransform(start4, end4));

        String start5 = "XRRXRX";
        String end5 = "RXLRRX";
        Assert.assertFalse(tester.canTransform(start5, end5));

        String start6 = "XRRXRX";
        String end6 = "RXLRRX";
        Assert.assertFalse(tester.canTransform(start6, end6));

        String start7 = "XLXRRXXRXX";
        String end7 = "LXXXXXXRRR";
        Assert.assertTrue(tester.canTransform(start7, end7));

    }

}
