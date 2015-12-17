package edu.ouc;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum 
 *  equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 * @author Administrator
 *
 */
public class _113_Path_Sum_II {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        find(root,root.val,sum);
        
        //dfs(root,sum,result,new ArrayList<Integer>());
        return result;
    }
    public void dfs(TreeNode root,int sum,List<List<Integer>> result,List<TreeNode> list){
    	if(root == null) return;
    	if(root.left == null && root.right == null){
    		list.add(root);
    		int tmp = 0;
    		for(TreeNode node : list){
    			tmp += node.val;
    		}
    		if(tmp == sum){
    			result.add(list);
    		}
    	}
    	list.add(root.val);
    	dfs(root.left,sum,result,list);
    	
    	dfs(root.right,sum,result,list);
    }
    public boolean find(TreeNode r ,int total, int sum){
        if(r.left == null && r.right == null)	return total == sum;
    	if(r.left == null)	return find(r.right,total+r.right.val,sum);
    	if(r.right == null)	return find(r.left,total+r.left.val,sum);
    	return find(r.right,total+r.right.val,sum) || find(r.left,total+r.left.val,sum);
    }
}
