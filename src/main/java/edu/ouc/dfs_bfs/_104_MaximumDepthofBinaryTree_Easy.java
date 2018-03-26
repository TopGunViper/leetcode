package edu.ouc.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth3(TreeNode root) {
    	if(root == null) return 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int level = 1;
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		for(int i = 0; i < size; i++){
    			TreeNode node = queue.poll();
    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    		}
    		if(queue.size() == 0) break;
    		level++;
    	}
    	return level;
    }
}
