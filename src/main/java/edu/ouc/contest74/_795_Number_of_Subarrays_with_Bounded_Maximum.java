package edu.ouc.contest74;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

public class _795_Number_of_Subarrays_with_Bounded_Maximum {

    /**
     * dp[i][j] = dp[i-1][j] + len,  if(A[i] >=L & A[i] <=R)
     *
     * @param A
     * @param L
     * @param R
     *
     * @return
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int retVal = 0;
        int j = 0, count = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                retVal += i - j + 1;
                count = i - j + 1;
            } else if (A[i] < L) {
                retVal += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return retVal;
    }

    /**
     * TLE!!!!
     */
    public int numSubarrayBoundedMax2(int[] A, int L, int R) {
        int retVal = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    if (A[k] >= max) {
                        max = A[k];
                    }
                }
                if (max >= L && max <= R) {
                    retVal++;
                }
            }
        }
        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _795_Number_of_Subarrays_with_Bounded_Maximum tester = new _795_Number_of_Subarrays_with_Bounded_Maximum();
        int[] A = {2, 1, 4, 3};
        int L = 2;
        int R = 3;

        Assert.assertTrue(tester.numSubarrayBoundedMax(A, L, R) == 3);

    }
}
