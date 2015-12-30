package edu.ouc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Administrator
 *
 */
public class _210_Course_Schedule_II_M {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
	    if(numCourses <= 0 || prerequisites.length == 0) return new int[0];
	    if(numCourses == 1) return new int[]{1};
		Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>(numCourses);
		int visited[] = new int[numCourses];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < prerequisites.length;i++){
			int v1 = prerequisites[i][0];
			int v2 = prerequisites[i][1];
			//get adjacent node
			List<Integer> adj = graph.get(v1);
			if(adj == null){
				adj = new ArrayList<Integer>();
			}
			adj.add(v2);
			graph.put(v1, adj);
		}

		
		for(int i = 0; i < numCourses; i++){
			if(visited[i] == 0 && dfs(i,stack,visited,graph)) return new int[0];
		}
		int[] path = new int[numCourses];
		for(int i = 0 ; i < numCourses; i++){
			path[i] = stack.pop();
		}
		return path;
    }
	public boolean dfs(int v,Stack<Integer> stack,int[] visited,Map<Integer,List<Integer>> graph){
		visited[v] = -1;
		if(graph.get(v) != null){
			for (Integer v2: graph.get(v)) {
				if (visited[v2] == -1) return true;
				else if (visited[v2] == 0 && dfs(v2,stack,visited, graph)) return true;
			}
		}
		visited[v] = 1;
		stack.push(v);
		return false;
	}
}
