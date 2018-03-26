package edu.ouc.dp;

import java.util.Arrays;

import org.junit.Assert;

public class _64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int j = 1; j < grid[0].length; j++){
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        //test case1
        _64_Minimum_Path_Sum
                tester = new _64_Minimum_Path_Sum();
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        Assert.assertEquals(7, tester.minPathSum(grid));

        int[][] grid2 = {{1,2},{5,6},{1,1}};
        Assert.assertEquals(8, tester.minPathSum(grid2));



    }
}
