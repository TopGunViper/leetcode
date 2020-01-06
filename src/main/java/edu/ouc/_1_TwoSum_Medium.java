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
