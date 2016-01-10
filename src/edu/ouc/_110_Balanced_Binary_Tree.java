package edu.ouc;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which 
the depth of the two subtrees of every node never differ by more than 1.


 * @author wqx
 * @date 2015-12-7
 *
 */
public class _110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
    	return depth(root) != -1;
    }
    public int depth(TreeNode root){
    	if(root == null)
    		return 0;
    	int left = depth(root.left);
    	int right = depth(root.right);
    	if(left == -1 || right == -1) return -1;
    	if(Math.abs(left - right) > 1){
    		return -1;
    	}else return Math.max(left, right)+1;
    }
}
