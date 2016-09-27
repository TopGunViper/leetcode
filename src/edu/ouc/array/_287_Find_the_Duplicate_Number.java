package edu.ouc.array;

/**
 *  Given an array nums containing n + 1 integers where each integer is between 1 and n 
 *  (inclusive), prove that at least one duplicate number must exist. 
 *  Assume that there is only one duplicate number, find the duplicate one.

Note:
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.

 * @author wqx
 *
 */
public class _287_Find_the_Duplicate_Number {

	/**
	 * n+1个1到n之间的数，必然会出现重复
	 * 
	 * 思路一：可以用Map，但是空间复杂度O(N)，不符合题意
	 * 
	 * 思路二：交换法，a[i] = j,判断a[j]是否等于j，若相等，则j就是重复数，若不等，交换a[i]和a[j]。
	 * 修改了数组，不符题意
	 * 
	 * 再想想。。。
	 * 
	 * 看Discuss了。。。
	 * 
	 * 别人的思路很惊人啊。。。。
	 * 
	 * 以数组为基础，构造一个图，a[i]=j,代表：节点i指向节点j的边。
	 * 由于出现重复元素，所以肯定会出现环！！！这点很重要
	 * 重复元素一定在环内，所以第一步找到环内的某个元素（任意一个都可以，只要在环内就行）
	 * 
	 * 链表找环时用的快慢指针在这里同样适用，
	 * slow = nums[slow];
	 * fast = nums[nums[fast]];
	 * 
	 * 哎。。。能想出这个。。。脑洞真大。。。。
	 * 
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		
		if (nums.length > 1)
		{
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast)
			{
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow)
			{
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}
	public static void main(String[] args) {
		
	}

}
