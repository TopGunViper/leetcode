package edu.ouc.contest73;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class _790_Domino_and_Tromino_Tiling {

    public int numTilings(int N) {
        int max = 1000000007;
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % max;
        }
        return (int) dp[N];
    }

    /**
     * A small rectangle(2*1 or 1*2) cover a big rectangle(2*N)
     * <p>
     * F[N] = F[N-1] + F[N-2], F[1]=1,F[2]=2
     *
     * @param N
     *
     * @return
     */
    public int numTilings2_N(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }

        int retVal = 0;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= N; i++) {
            retVal = f1 + f2;
            f1 = f2;
            f2 = retVal;
        }
        return retVal;
    }

    public int numTilings2_N_recursive(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }

        return numTilings2_N_recursive(N - 1) + numTilings2_N_recursive(N - 2);
    }

    public static void main(String args[]) {
        //test case1
        _790_Domino_and_Tromino_Tiling tester = new _790_Domino_and_Tromino_Tiling();
        int N = 3;
        Assert.assertEquals(5, tester.numTilings(N));

        int N2 = 3;
        Assert.assertEquals(3, tester.numTilings2_N(N2));
        Assert.assertEquals(3, tester.numTilings2_N_recursive(N2));
        int N3 = 5;
        Assert.assertEquals(8, tester.numTilings2_N(N3));
        Assert.assertEquals(8, tester.numTilings2_N_recursive(N3));

    }
}
