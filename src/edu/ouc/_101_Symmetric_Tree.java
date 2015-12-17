package edu.ouc;

/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

 * @author wqx
 *
 */
public class _101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode left,TreeNode right){
        if( left == null )
        	return right == null;
        if(right==null)
            return false;
        return (left.val == right.val) && isSameTree( left.left, right.right) && isSameTree(left.right,right.left);
    }
}
