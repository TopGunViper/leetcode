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
	public static void main(String args[]){
		int[] nums = {5,2,6,1};  
		countSmaller(nums);  
	}
	/**
	 * 时间复杂度：O(N*logN)，空间复杂度：O(N)，同归并排序
	 * 思路：
	 * 给定数组：[1 7 3 4 2 6],进行归并排序（递减）
	 * 归并过程中的某个状态如下：
	 * (7 3 1)(6 4 2)
	 * 此时 7 > 6,那么6之后的数一定也小于7，所以只要计算6之后还有多少个数就可以。
	 * 这里就是利用了归并排序中部分数组有序的特性
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> countSmaller(int[] nums) {
    	int len = nums.length;
    	List<Integer> counts = new ArrayList<Integer>();
    	Node[] array = new Node[len];
    	
    	for(int i = 0; i < len; i++){
    		Node node = new Node(nums[i],i);
    		counts.add(0);
    		array[i] = node;
    	}
    	mergeSort(array,0,len-1);
    	for(Node n : array){
    		counts.set(n.index,n.counts);
    	}
    	return counts;
	}
	public static void mergeSort(Node nums[],int low,int high){
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
	
	public static void merge(Node nums[],int low,int mid,int high){
		Node [] tmp = new Node[high-low+1];
		int i = low,j = mid+1,k = 0;
		
		while(i <= mid && j <= high){
			if(nums[i].elem > nums[j].elem){
				tmp[k] = nums[i];
				nums[i].counts += (high-j+1);
				k++;i++;
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
		for(int p = 0; p < tmp.length; p++){
			nums[low+p] = tmp[p];
		}
	}
	static class Node{
		int elem;
		int index;
		int counts;
		public Node(int elem,int index){
			this.elem = elem;
			this.index = index;
			counts = 0;
		}
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
