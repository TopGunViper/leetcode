package edu.ouc.contest73;

import java.util.Map;

import org.junit.Assert;

public class _789_Escape_The_Ghosts {


    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int targetDis = distance(0,0, target[0], target[1]);
        for(int i = 0; i < ghosts.length; i++){
            int dis = distance(ghosts[i][0],ghosts[i][1], target[0], target[1]);
            if(targetDis - dis >= 0){
                return false;
            }
        }
        return true;
    }

    private int distance(int x1,int y1, int x2, int y2){
        return Math.abs(x2 -x1) + Math.abs(y2 -y1);
    }
    public static void main(String args[]) {
        //test case1
        _789_Escape_The_Ghosts tester = new _789_Escape_The_Ghosts();
        int[][] ghosts = {{1, 0}, {0, 3}};
        int[] target = {0, 1};
        Assert.assertTrue(tester.escapeGhosts(ghosts, target));

        int[][] ghosts2 = {{1, 0}};
        int[] target2 = {2, 0};
        Assert.assertFalse(tester.escapeGhosts(ghosts2, target2));

        int[][] ghosts3 = {{2, 0}};
        int[] target3 = {1, 0};
        Assert.assertFalse(tester.escapeGhosts(ghosts3, target3));

        int[][] ghosts4 = {{28,13},{26,15},{20,21},{23,18},{4,5},{16,17},{38,3},{24,17},{34,7},{-6,-5}};
        int[] target4 = {20,-6};
        Assert.assertTrue(tester.escapeGhosts(ghosts4, target4));
    }
}
