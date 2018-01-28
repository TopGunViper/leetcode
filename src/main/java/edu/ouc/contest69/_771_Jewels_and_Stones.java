package edu.ouc.contest69;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _771_Jewels_and_Stones {


    public int numJewelsInStones(String J, String S) {
        int retVal = 0;
        for(Character c : S.toCharArray()){
            if(J.contains("" + c)){
                retVal ++;
            }
        }
        return retVal;
    }

    public static void main(String args[]) {
        //test case1
        _771_Jewels_and_Stones tester = new _771_Jewels_and_Stones();
        String J = "aA", S = "aAAbbbb";

        Assert.assertEquals(3, tester.numJewelsInStones(J, S));

        String J2 = "z", S2 = "ZZ";
        Assert.assertEquals(0, tester.numJewelsInStones(J2, S2));
    }

}
