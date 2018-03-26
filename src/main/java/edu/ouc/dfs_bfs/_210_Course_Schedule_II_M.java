package edu.ouc.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author wqx
 *
 */
public class _210_Course_Schedule_II_M {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(prerequisites == null){
			throw new IllegalArgumentException();
		}
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
	/**
	 * BFS solution
	 * @param numCourses
	 * @param prerequisites
	 * @return Topological order
	 */
	public int[] bfs(int numCourses, int[][] prerequisites) {
		int len = prerequisites.length;
		boolean[] visited = new boolean[numCourses];
		int[] path = new int[numCourses];
		int[] in_degree = new int[numCourses];
		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>(numCourses);

		for (int i = 0; i < len; i++) {
			int v1 = prerequisites[i][0];
			int v2 = prerequisites[i][1];
			in_degree[v1]++;
			//get adjacent node
			List<Integer> adj = graph.get(v2);
			if(adj == null){
				adj = new ArrayList<Integer>();
			}
			adj.add(v1);
			graph.put(v2, adj);
		}

		//所有入度为0的节点入队列
		for (int i = 0; i < numCourses; i++) {
			if (in_degree[i] == 0) {
				queue.offer(i);
			}
		}
		//bfs
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			visited[cur] = true;
			path[count] = cur;
			count++;
			if(graph.get(cur) != null){
				for(Integer v : graph.get(cur)){
					in_degree[v]--;
					//若节点入度为0且为访问则入队列
					if (in_degree[v] == 0 && visited[v] == false)
						queue.offer(v);
				}
			}

		}
		if (count == numCourses)
			return path;
		else
			return new int[0];
	}
//	for (int i = 0; i < len; i++) {
//	if (prerequisites[i][1] == cur) {
//		in_degree[prerequisites[i][0]]--;
//		if (in_degree[prerequisites[i][0]] == 0 && visited[prerequisites[i][0]] == false)
//			queue.offer(prerequisites[i][0]);
//	}
//}
}
