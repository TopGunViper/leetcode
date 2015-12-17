package edu.ouc;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 
 * @author wqx
 *
 */
public class _1_TwoSum_Medium {
	public int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i],i);
		}
		for(Integer a : map.keySet()){
			int tmp = target - a;
			if(map.get(tmp) != null){
				//System.out.println("index1:" + map.get(a) + ",index2:" + map.get(tmp));
				int index1 = map.get(a);
				int index2 = map.get(tmp);
				result[0] = index1+1;
				result[1] = index2+1;
				break;
			}
		}
		return result;
	}
	public int[] twoSum2(int[] nums, int target) {// My AC
		int result[] = new int[2];
		int len = nums.length;
		for(int i = 0; i < len; i++){
			int tmp = target - nums[i];
			for(int j=0; j< len;j++){
				if(j!=i && nums[j] == tmp){
					result[0] = i+1;
					result[1] = j+1;
					return result;
				}
			}
		}
		return null;
	}
	public int[] twoSum3(int[] numbers, int target) {
		int[] solution = new int[2];
		Hashtable<Integer, Integer> H = new Hashtable<Integer,Integer> (numbers.length);

		// O(n) time for adding each element to the Hash table.
		for(int i=0; i<numbers.length; i++) {
			H.put(numbers[i], i);
		}

		// Lookup for element index2 such that index2==(target-index1) (O(1)) 
		// O(1) for each lookup, O(n) total.
		for(int i=0; i<numbers.length; i++) {
			if(H.get(target-numbers[i]) != null && H.get(target-numbers[i])!=i) {
				solution[0] = i+1;
				solution[1] = H.get(target - numbers[i]) +1;
				break;
			}
			else continue;
		}
		return solution;
	}
	public int[] twoSum4(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < numbers.length; i++) {
			Integer index1 = map.get(target-numbers[i]);
			if (index1 != null) {
				return new int[]{index1,i+1};
			}
			map.put(numbers[i], i+1);
		}
		return null;
	}
}
