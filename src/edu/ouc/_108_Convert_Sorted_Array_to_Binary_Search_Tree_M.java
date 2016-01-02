package edu.ouc;

import java.util.List;
/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author wqx
 * Jan,2,2016
 *
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree_M {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }
    private static TreeNode createBST(int[] nums,int start,int end){
    	  if (start > end) return null;  
    	  int mid = start + (end - start) / 2;
    	  TreeNode node  = new TreeNode(nums[mid]);
    	  node.left = createBST(nums, start, mid-1);
    	  node.right= createBST(nums, mid+1, end);
    	  return node;
    }
}
