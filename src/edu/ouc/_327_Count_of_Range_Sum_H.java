package edu.ouc;

import java.util.ArrayList;
import java.util.List;


/**
 *  Given an integer array nums, return the number of range sums that lie in 
 *  [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between 
indices i and j (i ≤ j), inclusive.

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
	private int lower;
	private int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
    	this.lower = lower;
    	this.upper = upper;
    	
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
	public  List<Integer> countSmaller(int[] nums) {
    	int len = nums.length;
    	List<Integer> counts = new ArrayList<Integer>();
    	mergeSort(nums,0,len-1);
    	return counts;
	}
	public  void mergeSort(int nums[],int low,int high){
		int mid = (low+high)/2;
		if(low < high){
			// 左半边
			mergeSort(nums,low,mid);
			//右半边
			mergeSort(nums,mid+1,high);
			//左右两边有序数组合并
			merge(nums,low,mid,high);
		}
	}
	
	public  void merge(int nums[],int low,int mid,int high){
		int [] tmp = new int[high-low+1];
		int i = low,j = mid+1,k = 0;
		int p = mid+1,q = mid+1;
		while(i <= mid && j <= high){
			if(nums[i] < nums[j]){
				tmp[k] = nums[i];
				k++;i++;
		        while (p < high && nums[p] - nums[i] < lower) p++;
		        while (q < high && nums[j] - nums[i] <= upper) q++;
			}else {
				tmp[k++] = nums[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = nums[i++];
		}
		while(j <= high){
			tmp[k++] = nums[j++];
		}
		//新的有序数组覆盖旧数组
		for(p = 0; p < tmp.length; p++){
			nums[low+p] = tmp[p];
		}
	}
}
