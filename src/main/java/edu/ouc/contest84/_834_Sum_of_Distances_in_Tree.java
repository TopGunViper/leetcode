package edu.ouc.contest84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _834_Sum_of_Distances_in_Tree {
    int[] ans, count;
    List<Set<Integer>> graph;
    int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        graph = new ArrayList<Set<Integer>>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for (int i = 0; i < N; ++i)
            graph.add(new HashSet<Integer>());
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (int nei: graph.get(node))
            if (nei != parent) {
                dfs(nei, node);
                count[node] += count[nei];
                ans[node] += ans[nei] + count[nei];
            }
    }

    public void dfs2(int node, int parent) {
        for (int nei: graph.get(node))
            if (nei != parent) {
                ans[nei] = ans[node] - count[nei] + N - count[nei];
                dfs2(nei, node);
            }
    }
    public static void main(String args[]) {
        _834_Sum_of_Distances_in_Tree
                tester = new _834_Sum_of_Distances_in_Tree();
        String str = "abcdddeeeeaabbbcd";

    }
}
