package edu.ouc.array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the
 * sum ≥ s. If there isn't one, return -1 instead.
 */
public class _Minimum_Size_Subarray_Sum {

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public int minimumSize(int[] nums, int s) {
        int[] sum = new int[nums.length];
        int ans = Integer.MAX_VALUE;

        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int left = 0, right = 1;
        while (left < nums.length && right < nums.length) {
            if (sum[right] - sum[left] <= s) {
                ans = Math.min(ans, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minimumSize2(int[] nums, int s) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= s) {
                ans = Math.min(ans, r - l + 2);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        _Minimum_Size_Subarray_Sum tester =
                new _Minimum_Size_Subarray_Sum();

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(tester.minimumSize(nums, s));
    }
}
