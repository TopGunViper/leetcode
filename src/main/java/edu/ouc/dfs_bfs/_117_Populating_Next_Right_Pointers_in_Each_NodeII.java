package edu.ouc.dfs_bfs;

import java.util.ArrayList;
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

 For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL


 * @author wqx
 *
 */
public class _117_Populating_Next_Right_Pointers_in_Each_NodeII {
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		List<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
		List<Integer> levels = new ArrayList<Integer>();
		
		if(root == null)
			return ;
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			levels.add(size);
			for(int i = 0; i < size; i++){
				TreeLinkNode node = queue.poll();
				list.add(node);
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
		}
		for(int i = 0; i < levels.size(); i++){
			int start = 0,end = 0;
			if(i != 0){
				start = levels.get(i-1);
				end = start+levels.get(i)-1;
				levels.set(i, end+1);
			}
			while(start < end){
				list.get(start).next = list.get(start+1);
				start++;
			}
		}
	}
}
