package edu.ouc.contest75;

public class _799_Champagne_Tower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] >= 1) {
                    dp[i + 1][j] += (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2.0;
                    dp[i][j] = 1;
                }
            }
        }
        return dp[query_row][query_glass];
    }

    public static void main(String args[]) {
        //test case1
        _799_Champagne_Tower
                tester = new _799_Champagne_Tower();
        int poured = 2;
        int query_glass = 1;
        int query_row = 1;
        tester.champagneTower(poured, query_row, query_glass);
        //Assert.assertTrue(tester.numMatchingSubseq(S, words) == 3);

    }
}
