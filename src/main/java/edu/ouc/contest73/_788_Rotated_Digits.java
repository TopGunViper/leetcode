package edu.ouc.contest73;

import org.junit.Assert;

public class _788_Rotated_Digits {


    public int rotatedDigits(int N) {
        int retVal = 0;
        for(int i = 1; i <= N; i++){
            int t = i;
            boolean good = false;
            while(t != 0){
                int digit = t % 10;
                if(digit == 3 || digit == 4 || digit == 7){
                    good = false;
                    break;
                }
                if(t % 10 == 2 || t % 10 == 5 || t % 10 == 6 || t % 10 == 9){
                    good = true;
                }
                t /= 10;
            }
            if(good){
                retVal++;
            }
        }
        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _788_Rotated_Digits tester = new _788_Rotated_Digits();
        int x = 2;
        Assert.assertTrue(tester.rotatedDigits(x) == 1);

        int x2 = 10;
        Assert.assertTrue(tester.rotatedDigits(x2) == 4);

        int x3 = 857;
        Assert.assertTrue(tester.rotatedDigits(x3) == 247);
    }
}
