package edu.ouc.dp;

import org.junit.Assert;

public class _198_House_Robber {

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        //test case1
        _198_House_Robber
                tester = new _198_House_Robber();
        int[] nums = {9, 3, 6, 1};
        Assert.assertEquals(15, tester.rob(nums));

        int[] nums2 = {0, 3, 1};
        Assert.assertEquals(3, tester.rob(nums2));

        int[] nums3 = {0};
        Assert.assertEquals(0, tester.rob(nums3));


    }
}
