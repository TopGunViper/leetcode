package edu.ouc.contest71;

/**
 * @author wqx
 */
public class _783_Minimum_Distance_Between_BST_Nodes {

    public int minDiffInBST(TreeNode root) {
        preOrderTraverse(root);
        return min;
    }

    private int min = Integer.MAX_VALUE;
    private int pre = -1;

    public void preOrderTraverse(TreeNode node){
        if(node == null)
            return ;
        preOrderTraverse(node.left);

        if(pre != -1 && node.val - pre <= min){
            min = node.val - pre;
        }
        pre = node.val;
        preOrderTraverse(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String args[]) {
        //test case1
        _783_Minimum_Distance_Between_BST_Nodes tester = new _783_Minimum_Distance_Between_BST_Nodes();
        int N = 1, K = 1;
        //Assert.assertEquals(0, tester.kthGrammar(N, K));

    }
}
