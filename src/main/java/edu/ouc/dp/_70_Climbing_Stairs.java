package edu.ouc.dp;

import org.junit.Assert;

public class _70_Climbing_Stairs {
    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;
        if (n == 1) {
            return f1;
        }
        if (n == 2) {
            return f2;
        }
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = f2 + f1;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        //test case1
        _70_Climbing_Stairs
                tester = new _70_Climbing_Stairs();
        int n = 2;
        Assert.assertEquals(2, tester.climbStairs(n));

        int n2 = 3;
        Assert.assertEquals(3, tester.climbStairs(n2));

        int n3 = 10;
        Assert.assertEquals(89, tester.climbStairs(n3));

    }
}
