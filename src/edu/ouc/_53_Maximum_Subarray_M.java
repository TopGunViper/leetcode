package edu.ouc;

/**
 * Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.
More practice:

If you have figured out the O(n) solution, try coding another solution using 
the divide and conquer approach, which is more subtle.

 * @author wqx
 *
 */
public class _53_Maximum_Subarray_M {
	/**
	 * 时间复杂度：O(n*n) 华丽丽的 Time Limit Exceeded
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
     * 
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
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
}
