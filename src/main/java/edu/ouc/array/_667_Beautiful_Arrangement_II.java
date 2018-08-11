package edu.ouc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.Assert;

/**
 * Given two integers n and k, you need to construct a list which contains n different positive integers
 * ranging from 1 to n and obeys the following requirement:
 * <p>
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 * has exactly k distinct integers.
 * <p>
 * Note:
 * The n and k are in the range 1 <= k < n <= 104.
 */
public class _667_Beautiful_Arrangement_II {

    /**
     * refer to other's idea.
     */
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int c = 0;
        for (int v = 1; v < n - k; v++) {
            ans[c++] = v;
        }
        for (int i = 0; i <= k; i++) {
            ans[c++] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
        }
        return ans;
    }

    public static void main(String[] args) {

        //test case1
        _667_Beautiful_Arrangement_II
                tester = new _667_Beautiful_Arrangement_II();
        int[] expected = {1, 2, 3};
        int n = 3, k = 1;
        Assert.assertArrayEquals(expected, tester.constructArray(n, k));
        n = 3;
        k = 2;
        int[] expected2 = {1, 3, 2};
        Assert.assertArrayEquals(expected2, tester.constructArray(n, k));

    }
}
