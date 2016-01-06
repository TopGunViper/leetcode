package edu.ouc;

/**
 *  

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node 
to any node in the tree along the parent-child connections. The path does not need to 
go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 

 * @author wqx
 *
 */
public class _124_Binary_Tree_Maximum_Path_Sum_H {
	private int maxSum = 0;
	
	public int maxPathSum(TreeNode root) {
	    if (root == null)
	        return 0;
	    maxSum = root.val;
	    postOrderTraverse(root);
	    return maxSum;
	}

	private int postOrderTraverse(TreeNode root) {
	    if (root == null)
	        return 0;
	    int left = postOrderTraverse(root.left);
	    int right = postOrderTraverse(root.right);
	    int value = root.val;
	    if(left > 0) value += left;
	    if(right > 0) value += right;
	    if(value > maxSum) maxSum = value;
	    //返回root+left、root+right、root三者中的最大值
	    return Math.max(Math.max(left, right) + root.val, root.val);
	}
}
