package edu.ouc.array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the
 * sum ≥ s. If there isn't one, return -1 instead.
 */
public class _209_Minimum_Size_Subarray_Sum {

    /**
     * Time complexity: O(N*N)
     * Space complexity: O(N)
     */
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int curSum = sum[j] - sum[i] + nums[i];
                if(curSum >= s){
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * array sum[] is ascending, using binary search instead of sequential search.
     *
     * Time complexity: O(N*log(N))
     * Space complexity: O(N)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            int low = i, high = nums.length - 1;
            while (low <= high){
                int mid = low + (high - low)/2;
                int curSum = sum[mid] - sum[i] + nums[i];
                if(curSum >= s){
                    ans = Math.min(ans, mid - i + 1);
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public int minSubArrayLen3(int s, int[] nums) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int l = 0, i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        _209_Minimum_Size_Subarray_Sum tester =
                new _209_Minimum_Size_Subarray_Sum();

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(tester.minSubArrayLen(s ,nums));
        int[] nums2 = {1, 4, 4};
        s = 4;
        System.out.println(tester.minSubArrayLen(s ,nums2));
        int[] nums3 = {1,2,3,4,5};
        s = 11;
        System.out.println(tester.minSubArrayLen(s ,nums3));
        s = 213;
        int[] nums4 = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(tester.minSubArrayLen(s ,nums4));
    }
}
