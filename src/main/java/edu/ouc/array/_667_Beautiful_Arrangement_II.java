package edu.ouc.array;

import java.util.Arrays;

import org.junit.Assert;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as
 * extra space for the purpose of space complexity analysis.)
 */
public class _238_Product_of_Array_Except_Self {

    /**
     * bad idea!
     * <p>
     * encounter division by zero error if any element in <code>nums</code> has a value of zero.
     */
    public int[] productExceptSelf_bad_idea(int[] nums) {
        int product = Arrays.stream(nums).reduce((a, b) -> (a * b)).getAsInt();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] != 0 ? product / nums[i] : nums[i];
        }
        return nums;
    }

    /**
     * 1. Space Complexity: O(1)
     * 2. Time Complexity: O(N)
     *
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int res[] = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            res[i] *= prod;
        }
        return res;
    }


    public static void main(String[] args) {

        //test case1
        _238_Product_of_Array_Except_Self
                tester = new _238_Product_of_Array_Except_Self();
        int[] arr = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};

        Assert.assertArrayEquals(expected, tester.productExceptSelf(arr));

        int[] arr2 = {1,0};
        int[] expected2 = {0,1};

        Assert.assertArrayEquals(expected2, tester.productExceptSelf(arr2));
        int[] arr3 = {};
        int[] expected3 = {};

        Assert.assertArrayEquals(expected3, tester.productExceptSelf(arr3));

        int[] arr4 = {0,0};
        int[] expected4 = {0,0};

        Assert.assertArrayEquals(expected4, tester.productExceptSelf(arr4));

    }
}
