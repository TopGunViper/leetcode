package edu.ouc;

public class _104_MaximumDepthofBinaryTree_Easy {
	class TreeNode{
		int val;
		TreeNode right;
		TreeNode left;
		TreeNode(int x){val = x;}
	}
    public int maxDepth(TreeNode root) {
    	if(root == null)
    		return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
}
