package edu.ouc.contest77;

import java.util.Arrays;

public class _806_Number_of_lines_To_Write_String {

    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        int curNum = 0;
        int line = 0;
        for (Character c : S.toCharArray()) {
            if (curNum + widths[c - 'a'] > 100) {
                line++;
                curNum = widths[c - 'a'];
            } else {
                curNum += widths[c - 'a'];
            }
        }
        System.out.println("curNum:" + curNum);
        res[1] = curNum;
        res[0] = line+1;
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _806_Number_of_lines_To_Write_String
                tester = new _806_Number_of_lines_To_Write_String();
        int[] widths =
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10};
        String S = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(Arrays.toString(tester.numberOfLines(widths, S)));

        int[] widths2 =
                {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S2 = "bbbcccdddaaa";

        System.out.println(Arrays.toString(tester.numberOfLines(widths2, S2)));

    }
}
