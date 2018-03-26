package edu.ouc.contest63;

import com.sun.tools.javac.util.Assert;

/**
 * @author wqx
 */
public class _746_Min_Cost_Climbing_Stairs {


    /**
     * Solution:
     * Using DP firstly.
     * <p>
     * sum[i]: Assuming that the floor has stairs, sum[i] is the minimum cost if you reach the top of the floor
     * sum[i+1] = Min(sum[i] + cost[i], sum[i-1] + cost[i-1])
     *
     * @param cost
     *
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] sum = new int[cost.length + 1];
        sum[0] = sum[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            sum[i] = Math.min(sum[i - 1] + cost[i - 1], sum[i - 2] + cost[i - 2]);
        }
        return sum[cost.length];
    }

    public static void main(String args[]) {
        //test case1
        _746_Min_Cost_Climbing_Stairs tester = new _746_Min_Cost_Climbing_Stairs();

        int[] cost = {10, 15, 20};
        Assert.check(tester.minCostClimbingStairs(cost) == 15);

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Assert.check(tester.minCostClimbingStairs(cost2) == 6);

    }
}
