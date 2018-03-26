package edu.ouc.contest77;

public class _807_Max_Increase_to_Keep_City_Skyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] skylineLeft = new int[grid.length];
        int[] skylineTop = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int a : grid[i]) {
                if (a > max) {
                    max = a;
                }
            }
            skylineLeft[i] = max;
        }
        for (int j = 0; j < grid[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            skylineTop[j] = max;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int min = Math.min(skylineLeft[i], skylineTop[j]);
                sum += grid[i][j] < min ? (min - grid[i][j]) : 0;
            }
        }
        return sum;
    }


    public static void main(String args[]) {
        //test case1
        _807_Max_Increase_to_Keep_City_Skyline
                tester = new _807_Max_Increase_to_Keep_City_Skyline();
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(tester.maxIncreaseKeepingSkyline(grid));
    }
}
