package edu.ouc;

/**
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 * @author wqx
 * @Date 2015-11-30
 */
public class _98_Validate_Binary_Search_Tree {
	
	private long pre = Long.MIN_VALUE;
	private boolean flag = true;
	
    public boolean isValidBST(TreeNode root) {
        preOrderTraverse(root);
        return flag;
    }
    public void preOrderTraverse(TreeNode root){
    	if(root == null)
    		return ;
    	preOrderTraverse(root.left);
    	if(root.val <= pre ){	//前节点值 >= 当前节点值  return false;
    		flag = false;
    	}else{
    		pre = root.val;
    	}
    	preOrderTraverse(root.right);
    }
    /**
     * 较优解法
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if(node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
    
    
    long tmp =Long.MIN_VALUE;
    
    public boolean isValidBST3(TreeNode root) {
        if(root != null){
            boolean left = isValidBST(root.left);
            if(root.val<=tmp)
                return false;
            tmp = root.val;
            boolean right = isValidBST(root.right);
            if(!left || !right)
                return false;
        }
        return true;
    }
}
