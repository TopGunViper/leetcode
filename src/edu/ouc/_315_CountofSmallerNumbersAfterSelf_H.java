package edu.ouc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  You are given an integer array nums and you have to return a new counts array. 
 *  The counts array has the property where counts[i] is the number of smaller elements 
 *  to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Return the array [2, 1, 1, 0]. 

 * @author wqx
 *
 */
public class _315_CountofSmallerNumbersAfterSelf_H {
	
	/**
	 * 从nums[len-1]开始遍历
	 * 将当前元素右侧的数组进行排序，然后再进行二分查找
	 * 时间复杂度：O()
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmaller(int[] nums) {
    	int len = nums.length;
    	List<Integer> counts = new ArrayList<Integer>();
    	List<Integer> sortedArray = new ArrayList<Integer>();
    	if(len == 1){
    		counts.add(0);
    		return counts;
    	}
    	for(int i = len-2; i >= 0 ; i--){
    		int pos = findPosition(nums[i],sortedArray);
    		counts.add(pos);
    		
    	}
	}
	public int findPosition(int num,List<Integer> sortedArray){
		int low = 0,high = sortedArray.size();
		while(low <= high){
			int mid = (low+high)/2;
			if(sortedArray.get(mid) == num){
				return mid+1;
			}else if(sortedArray.get(mid) > num){
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return 
	}
	
	/**
	 * 时间复杂度O(n^2)  TLE!!!
	 * @param nums
	 * @return
	 */
    public List<Integer> countSmaller2(int[] nums) {
    	int len = nums.length;
    	List<Integer> counts = new ArrayList<Integer>();
    	for(int i = 0; i < len; i++){
    		int tmp = 0;
    		for(int j = i+1; j < len; j++){
    			if(nums[j] < nums[i])
    				tmp++;
    		}
    		counts.add(tmp);
    	}
    	return counts;
    }
}
