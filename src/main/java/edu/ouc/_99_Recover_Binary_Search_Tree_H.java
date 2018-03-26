package edu.ouc;

import java.util.Stack;

/**
 *
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. 
Could you devise a constant space solution?
 
 * @author wqx
 *
 */
public class _99_Recover_Binary_Search_Tree_H {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode pre = null, first = null, second = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null){
        	stack.push(node);
        	node = node.left;
        }
        //in-order traversal
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(pre != null){
            	if(pre.val > tmp.val){
            		if(first == null)
            			first = pre;
            		second = tmp;
            	}
            }
            //visited(tmp);
            pre = tmp;
            if(tmp.right != null){
            	tmp = tmp.right;
            	while(tmp != null){
            		stack.push(tmp);
            		tmp = tmp.left;
            	}
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
