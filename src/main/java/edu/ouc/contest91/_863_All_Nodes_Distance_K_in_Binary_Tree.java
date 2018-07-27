package edu.ouc.contest91;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;

import edu.ouc.TreeNode;
import javafx.util.Pair;

public class _863_All_Nodes_Distance_K_in_Binary_Tree {

//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        List<Integer> res = new ArrayList<>();
//        if (root.val == target.val) {
//            res = getNodes(target, K);
//        } else {
//            Pair<Integer/* distance */, Integer /* 1:left -1:right*/>  dis = getNodeDis(root.left, target);
//
//            List<Integer> res1 = getNodes(target, K);
//
//            if (disBetweenTargetAndRoot >= K) {
//                List<Integer> res2 = getNodes(root, disBetweenTargetAndRoot - K);
//            } else {
//                List<Integer> res2 = getNodes(target, disBetweenTargetAndRoot - K);
//            }
//        }
//    }

    public List<Integer> getNodes(TreeNode root, int level) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curLevel == level) {
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            curLevel++;
        }
        return res;
    }

    public Pair<Integer/* distance */, Integer /* 1:left -1:right*/> getNodeDis(TreeNode cur, TreeNode target) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(cur, 0));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> node = queue.poll();
                if (node.getKey().val == target.val) {
                    return new Pair(level, node.getValue());
                }
                if (node.getKey().left != null) {
                    queue.add(new Pair(node.getKey().left, 1));
                }
                if (node.getKey().right != null) {
                    queue.add(new Pair(node.getKey().right, -1));
                }
            }
            level++;
        }
        return null;
    }

    public static void main(String args[]) {
        //test case1
        _863_All_Nodes_Distance_K_in_Binary_Tree
                tester = new _863_All_Nodes_Distance_K_in_Binary_Tree();
        int p = 2, q = 1;
        //Assert.assertEquals(2, tester.distanceK(p, q));

    }
}
