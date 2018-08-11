package edu.ouc.array;

import java.util.stream.IntStream;

import org.junit.Assert;

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by
 * these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 * <p>
 * 1. The number at the ith position is divisible by i.
 * 2. i is divisible by the number at the ith position.
 * <p>
 * Now given N, how many beautiful arrangements can you construct?
 */
public class _526_Beautiful_Arrangement {

    int res = 0;

    public int countArrangement(int N) {
        int arr[] = IntStream.rangeClosed(0, N).toArray();
        search(arr, 1);
        return res;
    }

    public void search(int[] arr, int cur) {
        if (cur == arr.length) {
            res++;
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            swap(arr, cur, i);
            int curValue = arr[cur];
            if (isDivisible(curValue, cur) || isDivisible(cur, curValue)) {
                search(arr, cur + 1);
            }
            swap(arr, cur, i);
        }
    }

    private boolean isDivisible(int a, int b) {
        if (a < b) {
            return false;
        }
        return a % b == 0;
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {

        //test case1
        _526_Beautiful_Arrangement
                tester = new _526_Beautiful_Arrangement();
        int expected = 2;
        int n = 3;
        Assert.assertEquals(expected, tester.countArrangement(n));

    }
}
