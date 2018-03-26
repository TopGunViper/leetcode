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
	private static int counts;
	public static void main(String []args){
		int nums[] = {-2,5,-1};
		counts = 0;
		countRangeSum(nums,-2,2);
		System.out.println("counts:" + counts);
	}
    public static int countRangeSum(int[] nums, int lower, int upper) {
    	int len = nums.length;
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; ++i)
            sums[i + 1] = sums[i] + nums[i];
    	mergeSort(sums,0,len-1,lower,upper);
    	return counts;
    }
	/**
	 * sums[i]:表示nums中前i个数的和
	 * 则 S(i,j) = sums[j] - sums[i]
	 * 
	 * 
	 * @param sums
	 * @param low
	 * @param high
	 */
	public static  void mergeSort(int sums[],int low,int high,int lower, int upper){
		int mid = (low+high)/2;
		if(low < high){
			// 左半边
			mergeSort(sums,low,mid,lower,upper);
			//右半边
			mergeSort(sums,mid+1,high,lower,upper);
			//左右两边有序数组合并
			merge(sums,low,mid,high,lower,upper);
		}
	}
	/**
	 * 
	 * @param sums
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static  void merge(int sums[],int low,int mid,int high,int lower, int upper){
		int [] tmp = new int[high-low+1];
		int i = low,j = mid+1,k = 0;
		int p = mid+1,q = mid+1;
		System.out.println("low:" + low + ",high:" + high + ",mid:" + mid);
		while(i <= mid && j <= high){
	        while (p <= high && sums[p] - sums[i] < lower) p++;
	        while (q <= high && sums[j] - sums[i] <= upper) q++;
	        System.out.println("p:" + p + ",q:" + q);
	        counts += q-p;
	        
			if(sums[i] < sums[j]){
				tmp[k++] = sums[i++];
			}else {
				tmp[k++] = sums[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = sums[i++];
		}
		while(j <= high){
			tmp[k++] = sums[j++];
		}
		//新的有序数组覆盖旧数组
		for(p = 0; p < tmp.length; p++){
			sums[low+p] = tmp[p];
		}
	}
}
