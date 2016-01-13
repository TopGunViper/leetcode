package edu.ouc;

/**

Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

 * @author wqx
 *
 */
public class _215_Kth_Largest_Element_in_an_Array_M {
	/**
	 * 方法一：选择排序算法，只需找出前k个数即可
	 * @param nums
	 * @param k
	 * @return 第K大的数
	 */
    public int findKthLargest(int[] nums, int k) {
    	int len = nums.length;
        for(int i = 0; i < k; i++){
        	int max = i;
        	for(int j = i+1; j < len; j++){
        		if(nums[max] < nums[j]){
        			max = j;
        		}
        	}
        	if(max != i){
        		int t = nums[max];
        		nums[max] = nums[i];
        		nums[i] = t;
        	}
        }
        return nums[k-1];
    }
    /**
     * 找第K个数，堆排序最为合适
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
    	return 0;
    }
}
