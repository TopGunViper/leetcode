package edu.ouc.dfs_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node.
 If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree 
    (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 * @author wqx
 *
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		List<TreeLinkNode> list = new LinkedList<TreeLinkNode>();

		if(root == null)
			return ;
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeLinkNode node = queue.poll();
			list.add(node);
			if(node.left != null && node.right != null){
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		int level = 0;
		while(true){
			int start = (int) (Math.pow(2, level)) - 1;
			int num = 0;
			while(num < Math.pow(2, level)-1){
				list.get(start+num).next = list.get(start+num+1);
				num++;
			}
			list.get(start+num).next = null;
			level++;
			if((start+num) == list.size()-1){
				break;
			}
		}
	}
	/**
	 * 较优解法
	 * @param left
	 * @param right
	 */
	public void link(TreeLinkNode left, TreeLinkNode right){

	    if(left==null && right==null) return ;

	    left.next = right;
	    link(left.left,left.right);
	    link(left.right,right.left);
	    link(right.left,right.right);
	}
}
