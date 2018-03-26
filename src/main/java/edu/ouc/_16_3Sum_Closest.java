package edu.ouc;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is 
 * closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author TopGun
 * @date 2015-11-25
 * @idea:
 * 1.��SתΪ��������
 * 2.����s[0...i...n],��s[i]Ϊ���ģ��ҵ��� min{|s[i] + s[j] + s[k] - target|} (���� i < j < k)
 * 
 * PS:��Ŀ��˵����ÿ��Caseֻ��һ��solution�����������ٿ����ظ��������������
 */
public class _16_3Sum_Closest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len-1; i++){
        	int j = i+1, k = len-1;
        	while(j < k){
        		int gap = nums[j] + nums[i] + nums[k] - target;
        		if(Math.abs(gap) < minGap){
        			minGap = Math.abs(gap);
        			sum = nums[j] + nums[i] + nums[k];
        		}
        		if(gap >= 0){
        			k--;
        		}else if(gap < 0){
        			j++;
        		}
        	}
        }
        return sum;
    }
    public static void main(String args[]){
    	int[] nums = {-1,2,1,-4};
    	//-4,-1,1,2
    	int sum = threeSumClosest(nums,1);
    	System.out.println("sum:" + sum);
    }
}
