package edu.ouc.contest56;

import java.util.Arrays;

import com.sun.tools.javac.util.Assert;

/**
 * @author wqx
 */
public class _718_Maximum_Length_of_Repeated_Subarray {

    /**
     * Solution:
     * DP:
     * L[i,j] : 以A[i]和B[j]结尾的两个数组的最大重复子数组
     * L[i+1,j+1] = A[i] == B[j] ? L[i,j]+1 : 0;
     *
     * @param A
     * @param B
     *
     * @return
     */
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
        }
        for (int i = 0; i < B.length; i++) {
            dp[0][i] = A[0] == B[i] ? 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = max < dp[i][j] ? dp[i][j] : max;
                }
            }
        }
        return max;
    }

    /**
     * Solution:
     *
     * @param A
     * @param B TLE!!!!
     *
     * @return
     */
    public int findLength1(int[] A, int[] B) {
        int retVal = 0;
        int lenA = A.length;
        int lenB = B.length;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A[i] == B[j]) {
                    int k = 1;
                    int count = 1;
                    while (i + k < lenA && j + k < lenB) {
                        if (A[i + k] == B[j + k]) {
                            count++;
                        } else {
                            break;
                        }
                        k++;
                    }
                    retVal = retVal < count ? count : retVal;
                }
            }
        }
        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _718_Maximum_Length_of_Repeated_Subarray tester = new _718_Maximum_Length_of_Repeated_Subarray();

        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        Assert.check(tester.findLength(A, B) == 3);

        int[] A2 = {0,0,0,0,1};
        int[] B2 = {1,0,0,0,0};
        Assert.check(tester.findLength(A2, B2) == 4);


    }
}
