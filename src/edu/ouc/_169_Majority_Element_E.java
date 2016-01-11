package edu.ouc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element 
 * that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always exist 
in the array.
 * @author wqx
 * 自己的解法：用HashMap，key为数组中的值，value为值出现的次数
 * 
 * Moore's voting algorithm：
 * 该算法思想：
 * 每次找出一对不同的元素，从数组中删掉，知道数组为空或只剩一个元素。
 * 可以证明：如果存在元素e出现次数过半，那么最后剩下的只可能是e。
 * 
 * 
 */
public class _169_Majority_Element_E {
    public int majorityElement(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	if(nums.length == 1) return nums[0];
    	int threshold = nums.length / 2;
    	for(int i = 0; i < nums.length; i++){
    		Integer size = map.get(nums[i]);
    		if(size == null){
    			map.put(nums[i], 1);
    		}else if(size >= threshold){
    			return nums[i];
    		}else{
    			map.put(nums[i], size+1);
    		}
    	}
        return 0;
    }
    public static void main(String args[]){
        int a[] = {1,3,1,3,1,2,2,1,1,4,4};
        printMajority(a, a.length);
    }
    static void printMajority(int a[], int size)
    {
      /* Find the candidate for Majority*/
      int cand = findCandidate(a, size);
      
      /* Print the candidate if it is Majority*/
      if(isMajority(a, size, cand))
        System.out.println("cand:" + cand);
      else
    	  System.out.println("NO Majority Element");
    }
      
    /* Function to find the candidate for Majority */
    static int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for(i = 1; i < size; i++)
        {
            if(a[maj_index] == a[i]) 
            	count++;
            else 
            	count--;
            if(count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }
      
    /* Function to check if the candidate occurs more than n/2 times */
    static boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
          if(a[i] == cand)
             count++;
        if (count > size/2)
           return true;
        else
           return false;
    }
}
