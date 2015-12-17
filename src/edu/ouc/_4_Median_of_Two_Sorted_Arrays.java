package edu.ouc;

/**There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * @author Wqx
 * @date 2015-11-08
 * 
 */
public class _4_Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int midNum = (len1 + len2) / 2;
		int i = 0,j = 0,count = 0;

		while(i < len1 && j < len2){
			if(nums1[i] <= nums2[j]){
				i++;
			}else{
				j++;
			}
			count++;
			if(count == midNum)
				break;
		}
		if(count != midNum){
			while(i < len1){
				i++;count++;
				if(count == midNum)
					break;
			}
			while(j < len2){
				j++;count++;
				if(count == midNum)
					break;
			}
		}
		return 1.0;
	}
}
