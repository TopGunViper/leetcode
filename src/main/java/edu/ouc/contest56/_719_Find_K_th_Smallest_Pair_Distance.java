package edu.ouc.contest56;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Given an integer array, return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.
 * <p>
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 *
 * @author wqx
 */
public class _719_Find_K_th_Smallest_Pair_Distance {

    /**
     * Solution:
     * 1. brute force: O(N*(N-1)/2) O(N*N), TLE!!!
     * 2. find k-th numbers. classic binary search.
     *
     * @param nums
     * @param k
     *
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int low = nums[1] - nums[0];
        int high = nums[nums.length - 1] - nums[0];
        while (high - low > 1) {
            int mid = high + low >> 2;
            int rank = 0;
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                while(j < i && nums[i] - nums[j] > mid) {
                    j++;
                }
                rank += i - j;
            }
            if(k < rank){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        //test case1
        _719_Find_K_th_Smallest_Pair_Distance tester = new _719_Find_K_th_Smallest_Pair_Distance();

        int[] nums = {1, 6, 1};
        int k = 3;
        /**
         * (1,3) -> 2
         * (1,1) -> 0
         * (3,1) -> 2
         * Then the 1st smallest distance pair is (1,1), and its distance is 0.
         */
        assertTrue(tester.smallestDistancePair(nums, k) == 5);

    }
}
