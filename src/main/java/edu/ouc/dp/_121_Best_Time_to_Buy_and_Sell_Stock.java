package edu.ouc.dp;

import org.junit.Assert;

public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[] leftMin = new int[prices.length + 1];

        leftMin[1] = prices[0];
        for(int i = 2; i <= prices.length; i++){
            leftMin[i] = Math.min(prices[i - 1], leftMin[i - 1]);
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        //dp[i] = max(dp[i - 1] , price[i] - leftMin[i])
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.max(dp[i - 1], prices[i] - leftMin[i]);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        //test case1
        _121_Best_Time_to_Buy_and_Sell_Stock
                tester = new _121_Best_Time_to_Buy_and_Sell_Stock();
        int[] nums = {7, 1, 5, 3, 6, 4};
        Assert.assertEquals(5, tester.maxProfit(nums));

        int[] nums2 = {7, 6, 4, 3, 1};
        Assert.assertEquals(0, tester.maxProfit(nums2));

    }
}
