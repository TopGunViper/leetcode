package edu.ouc.contest70;

/**
 * @author wqx
 */
public class _778_Swim_in_Rising_Water {


    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                low = Math.min(low, grid[i][j]);
                high = Math.max(high, grid[i][j]);
            }
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean[][] visited = new boolean[n][n];
            boolean flag = (grid[0][0] > mid) ? false : search(mid, grid, n, visited, 0, 0);
            if (flag) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public final int[] stepX = {1, 0, -1, 0};
    public final int[] stepY = {0, 1, 0, -1};
    public boolean search(int mid,
                          int[][]grid,
                          int n,
                          boolean[][] visited,
                          int i,
                          int j) {
        visited[i][j] = true;
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        for (int k = 0; k < stepX.length; k++) {
            int nextPosX = i + stepX[k];
            int nextPosY = j + stepY[k];
            if (nextPosX >= 0 && nextPosX < n && nextPosY >= 0 && nextPosY < n && !visited[nextPosX][nextPosY] && grid[nextPosX][nextPosY] <= mid) {
                if (search(mid, grid, n, visited, nextPosX, nextPosY)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        //test case1
        _778_Swim_in_Rising_Water tester = new _778_Swim_in_Rising_Water();
        String J = "aA", S = "aAAbbbb";
        //Assert.assertEquals(3, tester.numJewelsInStones(J, S));
    }

}
