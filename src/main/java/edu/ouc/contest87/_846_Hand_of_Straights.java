package edu.ouc.contest87;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

public class _846_Hand_of_Straights {

    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : hand) {
            counts.put (num, counts.getOrDefault (num, 0) + 1);
        }
        Arrays.sort (hand);
        for (int num : hand) {
            if (counts.get (num) == 0)
                continue;
            for (int i = 0; i < W; i++) {
                if (!counts.containsKey (num + i) || counts.get (num + i) == 0)
                    return false;
                counts.put (num + i, counts.get (num + i) - 1);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        _846_Hand_of_Straights
                tester = new _846_Hand_of_Straights();
        int[] rec1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int M = 3;
        Assert.assertTrue(tester.isNStraightHand(rec1, M));
        int[] rec2 = {1,2,3,4,5};
        int M2 = 4;
        Assert.assertFalse(tester.isNStraightHand(rec2, M2));
        int[] rec3 = {5,1};
        int M3 = 2;
        Assert.assertFalse(tester.isNStraightHand(rec3, M3));


    }
}
