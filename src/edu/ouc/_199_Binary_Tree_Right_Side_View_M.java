package edu.ouc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4]. 

 * @author wqx
 *
 * 
 */
public class _199_Binary_Tree_Right_Side_View_M {
    public List<Integer> rightSideView(TreeNode root) {
    	if(root == null) return new ArrayList<Integer>(0);
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //保证queue中为通一高度的节点
        	int size = queue.size();
            for(int i = 0;i < size; i++){
                TreeNode node= queue.poll();
                if(i == size-1){ //最后一个节点
                    result.add(node.val);
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return result;
    }
}
