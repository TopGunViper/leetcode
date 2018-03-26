package edu.ouc.dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		List<List<Integer>> list = new ArrayList(new ArrayList<Integer>());
        return dfs(root,sum,list,new Stack<Integer>());
    }
    public List<List<Integer>> dfs(TreeNode root,int sum,List<List<Integer>> result,Stack<Integer> path){
    	if(root == null) return result;
    	path.push(root.val);
    	if(root.left == null && root.right == null && sum == root.val){
    		result.add(new ArrayList<Integer>(path));
    	}
    	dfs(root.left,sum-root.val,result,path);
    	dfs(root.right,sum-root.val,result,path);
    	path.pop();
    	return result;
    }
}
