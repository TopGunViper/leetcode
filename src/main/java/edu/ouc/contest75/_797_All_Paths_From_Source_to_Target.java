package edu.ouc.contest75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _797_All_Paths_From_Source_to_Target {


    public List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();

        int N = graph.length;

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(0, null));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node srcNode = queue.poll();
                for (int j = 0; j < graph[srcNode.cur].length; j++) {
                    Integer targetNodeIndex = graph[srcNode.cur][j];
                    //System.out.println("srcNode.cur:" + srcNode.cur + ",targetNodeIndex:" + targetNodeIndex);
                    if (targetNodeIndex == (N - 1)) {
                        Node pre = srcNode.pre;
                        //System.out.println("pre:" + pre.cur);
                        List<Integer> path = new LinkedList<>();
                        path.add(targetNodeIndex);
                        path.add(srcNode.cur);
                        while (pre != null) {
                            path.add(pre.cur);
                            pre = pre.pre;
                        }
                        path.sort((a, b) -> a - b);
                        res.add(path);
                    }
                    queue.offer(new Node(targetNodeIndex, srcNode));
                }
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    class Node {
        int cur;
        Node pre;

        public Node(int cur, Node pre) {
            this.cur = cur;
            this.pre = pre;
        }
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, res, path);

        return res;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int adjNode : graph[node]) {
            path.add(adjNode);
            dfs(graph, adjNode, res, path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        int N = graph.length;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = queue.poll();
                for (int adjNode : graph[list.get(list.size() - 1)]) {
                    List<Integer> newList = new LinkedList<>(list);
                    newList.add(adjNode);
                    if (adjNode == (N - 1)) {
                        res.add(newList);
                        continue;
                    }
                    queue.offer(newList);
                }
            }
        }
        //System.out.println(Arrays.toString(res.toArray()));
        return res;
    }


    public static void main(String args[]) {
        //test case1
        _797_All_Paths_From_Source_to_Target
                tester = new _797_All_Paths_From_Source_to_Target();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        tester.allPathsSourceTarget(graph);
        //Assert.assertTrue();

        int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        tester.allPathsSourceTarget(graph2);
    }
}
