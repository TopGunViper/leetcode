package edu.ouc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 * @author wqx
 *
 */
public class _15_3Sum_M {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 2) return result;
		Arrays.sort(nums);
		int len = nums.length;
		for(int i = 0; i < len; i++){
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			int target = 0 - nums[i];	//以nums[i]为中间元素，问题简化为找a,b,使得a+b=0-nums[i];
			int j = i+1, k = len - 1;
			//从两头遍历所有可能结果
			while(j < k){
				if(nums[j] + nums[k] == target){
					result.add(Arrays.asList(nums[i],nums[j],nums[k]));
					//排除可能存在的重复元素
					while(j < k && nums[j] == nums[j+1]) j++;
					while(j < k && nums[k] == nums[k-1]) k--;
					j ++; k--;
				}else if(nums[j] + nums[k] < target){
					j++;
				}else{
					k--;
				}
			}
		}
		return result;
	}
	public List<List<Integer>> threeSum2(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(nums == null || nums.length < 2) return result;
	    Arrays.sort(nums);

	    int len = nums.length;
	    for(int i = 0; i < len; i++) {
	        if(i > 0 && nums[i] == nums[i - 1]) continue;           // Skip same results
	        int target = 0 - nums[i];
	        int j = i + 1, k = len - 1;
	        while(j < k) {
	            if(nums[j] + nums[k] == target) {
	                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                while(j < k && nums[j] == nums[j + 1]) j++;     // Skip same results
	                while(j < k && nums[k] == nums[k - 1]) k--;     // Skip same results
	                j ++; k--;
	            } else if(nums[j] + nums[k] < target) {
	                j ++;
	            } else {
	                k --;
	            }
	        }
	    }
	    return result;
	}
}
