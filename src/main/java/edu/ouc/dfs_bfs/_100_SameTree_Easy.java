package edu.ouc.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _100_SameTree_Easy {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null){
			return q == null;
		}
		if(q == null)
			return false;
		return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
	}
	public boolean isSameTree_Iteration(TreeNode p, TreeNode q) {
		if(p == null){
			return q == null;
		}
		if(q == null)
			return false;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(p);
		queue.offer(q);
		while(!queue.isEmpty()){
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if( left == null && right == null){
				continue;
			}
			if(left == null || right == null){
				return false;
			}
			if(left.val != right.val) return false;
			queue.offer(left.left);
			queue.offer(right.left);
			queue.offer(left.right);
			queue.offer(right.right);
		}
		return true;
	}
}
