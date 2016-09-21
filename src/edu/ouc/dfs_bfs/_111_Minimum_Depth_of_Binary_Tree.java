package edu.ouc.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path 
from the root node down to the nearest leaf node.

 * @author wqx
 * @date 2015-11-27
 * @Idea
 * 广度优先搜索（BFS）
 */
public class _111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        Queue<Node> queue = new LinkedList<Node>();
        if(root == null){
        	return 0;
        }
        Node r = new Node(root);
        queue.offer(r);
        while(!queue.isEmpty()){
        	Node tmp = queue.poll();
        	if(tmp.getNode().right == null && tmp.getNode().left == null){
        		return tmp.getLevel();
        	}
        	if(tmp.getNode().left != null){
        		Node n = new Node(tmp.getNode().left,tmp.getLevel()+1);
        		queue.offer(n);
        	}
        	if(tmp.getNode().right != null){
        		Node n = new Node(tmp.getNode().right,tmp.getLevel()+1);
        		queue.offer(n);
        	}
        }
        return 0;
    }
    class Node{
    	TreeNode node;
    	int level;
    	public Node(TreeNode node){
    		this.node = node;
    		this.level = 1;
    	}
		public Node(TreeNode node,int level){
    		this.node = node;
    		this.level = level;
    	}
		public TreeNode getNode() {
			return node;
		}
		public void setNode(TreeNode node) {
			this.node = node;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
    }
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left==null && root.right==null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
    public int minDepth3(TreeNode root) {
    	if(root == null) return 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int level = 1;
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		for(int i = 0; i < size; i++){
    			TreeNode node = queue.poll();
    			if(node.left == null && node.right == null)
    				return level;
    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    		}
    		level++;
    	}
    	return level;
    }
}
