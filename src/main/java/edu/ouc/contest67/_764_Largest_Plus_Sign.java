package edu.ouc.contest67;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.tools.javac.util.Assert;

/**
 * @author wqx
 */
public class _764_Largest_Plus_Sign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // initializing grid
        Map<Integer, Set<Integer>> minesMap = new HashMap<>();

        for (int i = 0; i < mines.length; i++) {
            if (minesMap.get(mines[i][0]) == null) {
                minesMap.put(mines[i][0], new HashSet());
            }
            minesMap.get(mines[i][0]).add(mines[i][1]);
        }
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Set<Integer> set = minesMap.get(i);
            for (int j = 0; j < N; j++) {
                grid[i][j] = (set != null && set.contains(j)) ? 0 : 1;
            }
        }
        int largest = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (isPlusSign(grid, i, j, largest + 1)) {
                    largest++;
                }
            }
        }
        return largest;
    }

    private boolean isPlusSign(int[][] grid, int posX, int posY, int armLength) {
        int[] stepX = {0, 1, -1, 0};
        int[] stepY = {1, 0, 0, -1};
        for (int i = 0; i < armLength; i++) {
            for (int dir = 0; dir < 4; dir++) {
                int nextPosX = posX + stepX[dir] * i;
                int nextPosY = posY + stepY[dir] * i;
                if (nextPosX < 0 || nextPosX >= grid.length || nextPosY < 0 || nextPosY >= grid.length ||
                        grid[nextPosX][nextPosY] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        //test case1
        _764_Largest_Plus_Sign tester = new _764_Largest_Plus_Sign();
        int N = 5;
        int[][] mines = {{4, 2}};
        Assert.check(tester.orderOfLargestPlusSign(N, mines) == 2);

        N = 2;
        int[][] mines2 = {};
        Assert.check(tester.orderOfLargestPlusSign(N, mines2) == 1);

        N = 1;
        int[][] mines3 = {{0, 0}};
        Assert.check(tester.orderOfLargestPlusSign(N, mines3) == 0);
    }
}
