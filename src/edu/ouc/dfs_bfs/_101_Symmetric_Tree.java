package edu.ouc.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

 * @author wqx
 *
 */
public class _101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }
        return isSymmetricTree(root.left,root.right);
    }
    public boolean isSymmetricTree(TreeNode left,TreeNode right){
        if( left == null )
        	return right == null;
        if(right==null)
            return false;
        return (left.val == right.val) && isSymmetricTree( left.left, right.right) && isSymmetricTree(left.right,right.left);
    }
    public boolean isSymmetric_Iteration(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
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
            //enqueue order: T1->T4->T2->T3
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
    /**
     * 斐波那契数列求第n项
     * 递归解法
     * @param n
     * @return
     */
    public int fib_recursion(int n){
    	if(n == 0 || n == 1) return n;
    	else return fib_recursion(n-1) + fib_recursion(n-2);
    }
    /**
     * 斐波那契数列求第n项
     * 迭代解法
     * @param n
     * @return
     */
    public int fib_iteration(int n){
    	int curValue=1,preValue=0;
    	if(n == 0 || n == 1)return n;
    	for(int i = 2; i < n; i++){
    		int tmp = curValue;
    		curValue = curValue + preValue;
    		preValue = tmp;
    	}
    	return curValue;
    }
}
