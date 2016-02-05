package edu.ouc;

/**
 *  Given an integer array nums, return the number of range sums that lie in 
 *  [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between 
indices i and j (i ¡Ü j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2. 

 * @author wqx
 * 
 */
public class _327_Count_of_Range_Sum_H {
    public int countRangeSum(int[] nums, int lower, int upper) {
        for(int i = 1; i < nums.length; i++){
        	nums[i] = nums[i] + nums[i-1];
        }
        if(lower < 0) lower = 0;
        if(upper >= nums.length) upper = nums.length-1;
        if(lower == 0){
        	return nums[upper];
        }
        return nums[upper] - nums[lower];
    }
}
