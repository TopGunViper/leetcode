package edu.ouc;

public class NumArray {
		private int []result;
		
		public NumArray(int[] nums) {
		    for(int i = 1; i < nums.length; i++)
		        nums[i] += nums[i - 1];
		    this.result = nums;
		}

		public int sumRange(int i, int j) {
			if(i == 0)
		        return result[j];
		    return result[j] - result[i - 1];
		}
}
