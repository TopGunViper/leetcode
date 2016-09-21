package edu.ouc.dfs_bfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

 * @author wqx
 * @date 2015-12-18
 * 
 */
public class _114_Flatten_Binary_Tree_to_Linked_List {
	private List<TreeNode> preOrder = new ArrayList<TreeNode>(0);
    public void flatten(TreeNode root) {
    	if(root == null) return ;
    	preOrderTraverse(root);
    	for(TreeNode node : preOrder)
    		System.out.println(node.val + ",");
    	createTree(root);
    }
    public void createTree(TreeNode root){
    	Iterator<TreeNode> it = preOrder.iterator();
    	TreeNode n = root = it.next();
    	while(it.hasNext()){
    		TreeNode node = it.next();
    		n.right = node;
    		n.left = null;
    		n = node;
    	}
    	n.left = n.right = null;
    }
    public void preOrderTraverse(TreeNode root){
    	if(root == null) return ;
    	preOrder.add(root);
    	preOrderTraverse(root.left);
    	preOrderTraverse(root.right);
    }
}
