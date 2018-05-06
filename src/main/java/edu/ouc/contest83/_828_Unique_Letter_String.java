package edu.ouc.contest83;

import java.util.Arrays;

public class _828_Unique_Letter_String {

    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) {
            Arrays.fill(index[i], -1);
        }

        int res = 0, N = S.length(), mod = (int) Math.pow(10, 9) + 7;

        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c][0] = index[c][1];
            index[c][1] = i;
        }
        for (int c = 0; c < 26; ++c) {
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        }
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _828_Unique_Letter_String
                tester = new _828_Unique_Letter_String();
        int N = 9;
        //System.out.println(tester.consecutiveNumbersSum(N));
        N = 4;
    }
}
