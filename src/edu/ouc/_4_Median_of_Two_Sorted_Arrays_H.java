package edu.ouc;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * @author wqx
 *
 */
public class _4_Median_of_Two_Sorted_Arrays_H {
	/**
	 * 1.先合并再查找，时间复杂度O(N),不符合条件
	 * 2.对数级别的时间复杂度，选用二分查找。
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int pre = -1,cur = -1;
		int i = 0, j = 0,pos = 0;
		while(i < len1 && j < len2){
			if(nums1[i] < nums2[j]){
				pre = cur;             /*保存前序节点值*/
				cur = nums1[i++];
			}else{
				pre = cur;
				cur = nums2[j++];
			}
			if(pos == (len1+len2)/2)
				return (len1+len2)%2 == 0 ? (cur+pre)*1.0/2 : cur;
			pos++;
		}
		while(i < len1){
			pre = cur;
			cur = nums1[i++];
			if(pos == (len1+len2)/2)
				return (len1+len2)%2 == 0 ? (cur+pre)*1.0/2 : cur;
			pos++;
		}
		while(j < len2){
			pre = cur;
			cur = nums2[j++];
			if(pos == (len1+len2)/2)
				return (len1+len2)%2 == 0 ? (cur+pre)*1.0/2 : cur;
			pos++;
		}
		return 0.0;
	}
	public static void main(String[] args){
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {6,7,8,9};
		System.out.println("findMedianSortedArrays:" + findMedianSortedArrays(arr1,arr2));
	}
}
