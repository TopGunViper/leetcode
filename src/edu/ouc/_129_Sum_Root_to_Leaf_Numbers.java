package edu.ouc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path 
 * could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. 
 * @author wqx
 *
 */
public class _129_Sum_Root_to_Leaf_Numbers {
	private List<String> result = new ArrayList<String>();
	
    public int sumNumbers(TreeNode root) {
    	sum(root,"");
    	int s = 0;
    	for(String str : result){
    		int r = Integer.valueOf(str);
    		s += r;
    	}
    	return s;
    }
    public void sum(TreeNode root,String sum){
    	if(root == null)
    		return ;
    	if(root.left == null && root.right == null){
    		result.add(sum + root.val);
    	}
    	sum(root.right,sum+root.val);
    	sum(root.left,sum+root.val);
    }
    
    /*
     * 较优解法
     * */
//    int result=0;
//    public int sumNumbers2(TreeNode root) {
//        if (root==null) return 0;
//        addValues(root, root.val);
//        return result;
//    }
//
//    public void addValues(TreeNode node, int value){
//        if (node.left==null && node.right==null) result+=value;
//        if (node.left!=null) addValues(node.left, value*10+node.left.val);
//        if (node.right!=null) addValues(node.right, value*10+node.right.val);
//    }
}
