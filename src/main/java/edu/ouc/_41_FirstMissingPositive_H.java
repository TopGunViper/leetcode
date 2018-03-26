package edu.ouc;

/**
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 

 * @author wqx
 *
 */
public class _41_FirstMissingPositive_H {
	public static void main(String [] args){
		int nums[] = {1,2,3,4,5};
		int missNum = missNumber(nums);
		System.out.println("missNum:" + missNum);
	}
	/**
	 * ��������l��r,�������£�
	 * 
	 * L:���ռ������������飬1-L
	 * R:Ԥ�ƿ����ռ����������� 1-R
	 * ʲô���������飺��1��ʼ����������������ɵ����顣
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	public static int missNumber(int[] nums){
		int l = 0;
		int r = nums.length;
		while(l < r){
			if(nums[l] == l+1){
				l++;
			}else if(nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]){
				nums[l] = nums[--r];
			}else{
				swap(nums,l,nums[l]-1);
			}
		}
		return 	l+1;
	}
	public static void swap(int[] nums,int l,int r){
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
}
