package edu.ouc;

/**

Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.

 * @author wqx
 *
 */
public class _215_Kth_Largest_Element_in_an_Array_M {
	/**
	 * 方法一：选择排序算法，只需找出前k个数即可
	 * @param nums
	 * @param k
	 * @return 第K大的数
	 */
	public int findKthLargest2(int[] nums, int k) {
		int len = nums.length;
		for(int i = 0; i < k; i++){
			int max = i;
			for(int j = i+1; j < len; j++){
				if(nums[max] < nums[j]){
					max = j;
				}
			}
			if(max != i){
				int t = nums[max];
				nums[max] = nums[i];
				nums[i] = t;
			}
		}
		return nums[k-1];
	}
	/**
	 * 利用快排的partition，使pivot逐步逼近k。时间复杂度O(nlogk)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		if(nums.length == 1) return nums[0];
		int start = 0,end = nums.length-1;
		while(start <= end){
			int pivot = partition(nums, start, end);
			//System.out.print("pivot:" + pivot);
			if (pivot == k-1) {
				return nums[pivot];
			} else if (pivot > k-1) {
				end = pivot-1;
			} else{
				start = pivot+1;
			}
		}
		return 0;
	}
	/**
	 * 以第一个元素为基准数，从大到小排序
	 * @param array
	 * @param low
	 * @param high
	 * @return 返回基准数位置
	 */
	private  int partition(int array[], int low, int high) {
		int key = array[low];
		while(low < high){
			while(low < high && array[high] < key){
				high--;
			}
			if(low < high)
				array[low++] = array[high];
			
			while(low < high && array[low] > key){
				low++;
			}
			if(low < high)
				array[high--] = array[low];
		}
		array[low] = key;
		return low;
	}
}
