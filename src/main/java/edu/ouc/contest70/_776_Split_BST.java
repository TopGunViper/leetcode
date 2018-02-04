package edu.ouc.contest70;

/**
 * @author wqx
 */
public class _776_Split_BST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (root.val > V) {
            res[1] = root;
            TreeNode[] res1 = splitBST(root.left, V);
            root.left = res1[1];
            res[0] = res1[0];
        } else {
            res[0] = root;
            TreeNode[] res1 = splitBST(root.right, V);
            root.right = res1[0];
            res[1] = res1[1];
        }
        return res;
    }

    public static void main(String args[]) {
        //test case1
        _776_Split_BST tester = new _776_Split_BST();
        String J = "aA", S = "aAAbbbb";
        //Assert.assertEquals(3, tester.numJewelsInStones(J, S));
    }

}
