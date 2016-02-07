package edu.ouc;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * @author wqx
 * 
 *
 */
public class _88_Merge_Sorted_Array_E {
	/**
	 * 归并排序中的合并有序数组步骤
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		int [] tmp = new int[m+n];
		int i = 0,j = 0,k = 0;
		
		while(i < m && j < n){
			if(nums1[i] < nums2[j]){
				tmp[k++] = nums1[i++];
			}else{
				tmp[k++] = nums2[j++];
			}
		}
		while(i < m){
			tmp[k++] = nums1[i++];
		}
		while(j < n){
			tmp[k++] = nums2[j++];
		}
		//新的有序数组覆盖旧数组
		for(int p = 0; p < tmp.length; p++){
			nums1[p] = tmp[p];
		}
    }
}
