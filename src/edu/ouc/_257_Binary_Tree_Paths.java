package edu.ouc;

import java.util.ArrayList;
import java.util.List;
/**
 *  Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]

 * @author wqx
 * @date 2015-12-7
 *
 */

public class _257_Binary_Tree_Paths {
	
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> result = new ArrayList<String>();
    	if(root == null)
    		return result;
    	dfs(root,"",result);
    	return result;
    }
    public void dfs(TreeNode root,String path,List<String> result){
    	if(root == null)
    		return;
    	if(root.right == null && root.left == null){
    		result.add(path + root.val);
    		return ;
    	}
    	path += root.val + "->";
   		dfs(root.left,path,result);
   		dfs(root.right,path,result);
    }
}
