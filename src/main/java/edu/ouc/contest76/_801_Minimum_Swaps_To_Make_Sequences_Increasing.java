package edu.ouc.contest76;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;

public class _801_Minimum_Swaps_To_Make_Sequences_Increasing {

    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[][] dp = new int[N][2];

        for(int i = 0; i < N; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }
        }
        return Math.min(dp[N - 1][0], dp[N - 1][1]);
    }

    public static void main(String args[]) {
        //test case1
        _801_Minimum_Swaps_To_Make_Sequences_Increasing
                tester = new _801_Minimum_Swaps_To_Make_Sequences_Increasing();
        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};

        System.out.println(tester.minSwap(A, B));
        Assert.assertEquals(1, tester.minSwap(A, B));

        int[] A2 = {0, 3, 5, 8, 9};
        int[] B2 = {2, 1, 4, 6, 9};

        System.out.println(tester.minSwap(A2, B2));
        Assert.assertEquals(1, tester.minSwap(A2, B2));

    }
}
