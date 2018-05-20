package edu.ouc.contest85;

import org.junit.Assert;

public class _836_Rectangle_Overlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1]);
    }

    public static void main(String args[]) {
        _836_Rectangle_Overlap
                tester = new _836_Rectangle_Overlap();
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        Assert.assertTrue(tester.isRectangleOverlap(rec1,rec2));

    }
}
