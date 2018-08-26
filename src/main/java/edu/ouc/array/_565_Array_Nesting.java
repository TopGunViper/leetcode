package edu.ouc.array;

import static org.junit.Assert.assertEquals;

/**
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set
 * S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * <p>
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S
 * should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 */
public class _565_Array_Nesting {

    /**
     * Time Complexity: O(N*N)
     * Space Complexity: O(1)
     * <p>
     * 853 / 856 test cases passed. Status: Time Limit Exceeded
     */
    public int arrayNesting_1(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
            } while (start != nums[i]);
            res = Math.max(res, count);

        }
        return res;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int cur = nums[i], count = 0;
                while (nums[cur] != Integer.MAX_VALUE) {
                    int next = nums[cur];
                    nums[cur] = Integer.MAX_VALUE;
                    cur = next;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _565_Array_Nesting tester = new _565_Array_Nesting();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        assertEquals(4, tester.arrayNesting(nums));

    }
}
