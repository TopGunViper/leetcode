package edu.ouc.contest53;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.tools.javac.util.Assert;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * @author wqx
 */
public class _695_Max_Area_of_Island {

    /**
     * Solution:
     * visit all grid + DFS.
     *
     * @param grid
     *
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int retVal = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                AtomicInteger maximumArea = new AtomicInteger(0);
                visitGrid(i,j,grid,visited,maximumArea);
                retVal = retVal > maximumArea.get() ? retVal : maximumArea.get();
            }
        }
        return retVal;
    }

    private int[] row = {1, -1, 0, 0};
    private int[] col = {0, 0, 1, -1};

    private void visitGrid(int curRow, int curCol, int[][] grid, boolean[][] visited, AtomicInteger maximumArea) {
        if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid[0].length || visited[curRow][curCol]
                == true) {
            return;
        }
        visited[curRow][curCol] = true;
        if (grid[curRow][curCol] == 0) {
            return;
        }
        maximumArea.incrementAndGet();
        for (int step = 0; step < 4; step++) {
            int nextRow = curRow + row[step];
            int nexCol = curCol + col[step];
            visitGrid(nextRow, nexCol, grid, visited, maximumArea);
        }
    }

    public static void main(String args[]) {
        //test case1
        _695_Max_Area_of_Island tester = new _695_Max_Area_of_Island();

        int[][] testGrid1 = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        /**
         * Given the above grid, return 6
         */
        Assert.check(tester.maxAreaOfIsland(testGrid1) == 6);

        int[][] testGrid2 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        // Given the above grid, return 0
        Assert.check(tester.maxAreaOfIsland(testGrid2) == 0);

        int[][] testGrid3 = {{0, 0, 0, 0, 1, 0, 0, 0}};
        // Given the above grid, return 1
        Assert.check(tester.maxAreaOfIsland(testGrid3) == 1);

        int[][] testGrid4 = {{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}};
        // Given the above grid, return 0
        Assert.check(tester.maxAreaOfIsland(testGrid4) == 0);

    }
}
