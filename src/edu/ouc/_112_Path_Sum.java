package edu.ouc;

/**
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
 *  that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author wqx
 *
 */
public class _112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return find(root,root.val,sum);
    }
    public boolean find(TreeNode r ,int total, int sum){
        if(r.left == null && r.right == null)	return total == sum;
    	if(r.left == null)	return find(r.right,total+r.right.val,sum);
    	if(r.right == null)	return find(r.left,total+r.left.val,sum);
    	return find(r.right,total+r.right.val,sum) || find(r.left,total+r.left.val,sum);
    }
}
