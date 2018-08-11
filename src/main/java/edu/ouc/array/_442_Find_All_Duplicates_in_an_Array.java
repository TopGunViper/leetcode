package edu.ouc.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 */
public class _442_Find_All_Duplicates_in_an_Array {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[i] != 0 && nums[i] - 1 != i) {
                if (nums[nums[i] - 1] == nums[i]) {
                    res.add(nums[i]);
                    nums[i] = 0;
                    i++;
                } else {
                    // swap
                    swap(nums, i, nums[i] - 1);
                }
            } else {
                i++;
            }
        }
        return res;
    }

    public List<Integer> findDuplicates_nice_solution(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {

        //test case1
        _442_Find_All_Duplicates_in_an_Array
                tester = new _442_Find_All_Duplicates_in_an_Array();
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        Integer[] expected = {3, 2};
//        System.out.println(Arrays.toString(tester.findDuplicates_nice_solution(arr).toArray()));

        Assert.assertArrayEquals(expected, tester.findDuplicates(arr).toArray());

    }
}
