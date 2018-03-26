package edu.ouc.contest68;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _769_Max_Chunks_To_Make_Sorted {


    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }


    public static void main(String args[]) {
        //test case1
        _769_Max_Chunks_To_Make_Sorted tester = new _769_Max_Chunks_To_Make_Sorted();
        int[] arr = {4, 3, 2, 1, 0};
        Assert.assertEquals(1, tester.maxChunksToSorted(arr));

        int[] arr2 = {1, 0, 2, 3, 4};
        Assert.assertEquals(4, tester.maxChunksToSorted(arr2));

        int[] arr3 = {0};
        Assert.assertEquals(1, tester.maxChunksToSorted(arr3));

        int[] arr4 = {0,2,1,4,3};
        Assert.assertEquals(3, tester.maxChunksToSorted(arr4));

    }

}
