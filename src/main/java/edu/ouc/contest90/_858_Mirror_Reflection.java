package edu.ouc.contest90;

import org.junit.Assert;

public class _858_Mirror_Reflection {


    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g; p %= 2;
        q /= g; q %= 2;

        if (p == 1 && q == 1) return 1;
        return p == 1 ? 0 : 2;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        while (a % b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return b;
    }

    public static void main(String args[]) {
        //test case1
        _858_Mirror_Reflection
                tester = new _858_Mirror_Reflection();
        int p = 2, q = 1;
        Assert.assertEquals(2, tester.mirrorReflection(p, q));

    }
}
