package edu.ouc;

/**
 * Maximum Subarray
 * 
 Find the contiguous subarray within an array (containing at least one number) 
 which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6. 

If you have figured out the O(n) solution, try coding another solution using 
the divide and conquer approach, which is more subtle.

 * @author wqx
 *
 */
public class _53_Maximum_Subarray_M {

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray1(int[] nums) {
		int len = nums.length;
		int max = nums[0], sum = nums[0];

		for(int i = 1; i < len; i++){
			if(sum < 0)
				sum = 0;
			sum += nums[i];
			if(sum > max)
				max = sum;
		}
		return max;
	}    
	/**
	 *  Time Limit Exceeded
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		int len = nums.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++){
			int sum = 0;
			for(int j = i; j < len; j++){
				sum += nums[j];
			}
			if(sum > max)
				max = sum;
		}
		return max;
	}
	/**
	 * 内部类Array用于存储当前子数组的以下信息：
	 * 1.maxLeft:从数组第一个元素开始，最大连续字数组和
	 * 2.maxRight:从数组最后一个元素开始，最大连续字数组和
	 * 3.sum:字数组所有元素之和
	 * 
	 * @param nums
	 * @return
	 */
	class Array{                                 
		public int maxLeft;
		public int maxRight;
		public int sum;
		public int maxSum = Integer.MIN_VALUE;;//最大子数组和
	}

	public void maxSubArray0(int[] nums,int left ,int right,Array arr){
		if(left == right){
			arr.maxLeft = nums[left];
			arr.maxRight = nums[left];
			arr.sum = nums[left];
			arr.maxSum = nums[left];
		}else{
			int mid = (left+right)/2;
			System.out.println("mid:" + mid);
			Array leftArray = new Array();
			Array rightArray = new Array();
			maxSubArray0(nums,left,mid,leftArray);
			maxSubArray0(nums,mid+1,right,rightArray);

			arr.maxLeft = Math.max(leftArray.maxLeft,leftArray.sum + rightArray.maxLeft);
			arr.maxRight = Math.max(rightArray.maxRight,rightArray.sum + leftArray.maxRight);
			arr.sum = leftArray.sum + rightArray.sum;
			arr.maxSum = Math.max(leftArray.maxSum, rightArray.maxSum);
			arr.maxSum = Math.max(arr.maxSum,leftArray.maxRight+rightArray.maxLeft);
		}
	}
	public int maxSubArray(int[] nums) {
		if(nums.length == 0)    return 0;
		if(nums.length == 1)    return nums[0];
		Array arr = new Array();
		maxSubArray0(nums, 0, nums.length - 1,arr);
		return arr.maxSum;
	}
}
