package edu.ouc.contest85;

public class _837_New_21_Game {

    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        double dp[] = new double[N + 1];
        dp[0] = 1.0;
        double Wsum = 1.0, res = 0.0;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i]; else res += dp[i];
            if (0 <= i - W && i - W < K) Wsum -= dp[i - W];
        }
        return res;
    }
    public static void main(String args[]) {
        //test case1
        _837_New_21_Game
                tester = new _837_New_21_Game();
        int N = 9;
        //System.out.println(tester.consecutiveNumbersSum(N));
        N = 4;
    }
}
