package edu.ouc.contest73;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class _790_Domino_and_Tromino_Tiling {


    public int numTilings(int N) {
        int max = 1000000007;
        if (N == 1) return 1;
        if (N == 2) return 2;
        long[] dp = new long[N + 1];
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % max;
        }
        return (int) dp[N];
    }
    public static void main(String args[]) {
        //test case1
        _790_Domino_and_Tromino_Tiling tester = new _790_Domino_and_Tromino_Tiling();
        int N = 3;
        Assert.assertEquals(5, tester.numTilings(N));

    }
}
