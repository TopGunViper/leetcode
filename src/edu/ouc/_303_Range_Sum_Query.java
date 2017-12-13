package edu.ouc;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j); inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.

 * @author wqx 2015-11-11
 * 
 */
public class _303_Range_Sum_Query {

	public static void main(String args[]){
	    int[] nums = new int[3];
		 NumArray numArray = new NumArray(nums);
		 numArray.sumRange(0, 1);
		 numArray.sumRange(1, 2);
		 
		 
	}
}
