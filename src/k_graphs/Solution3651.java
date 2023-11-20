package k_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://www.lintcode.com/problem/3651/
 * @author: Yidan
 * @create: 2023-11-19 16:34
 **/

public class Solution3651 {
  public int countComponents(int n, int[][] edges) {
    // write your code here
    boolean[] visited = new boolean[n];
    List<List<Integer>> neighbors = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      neighbors.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      neighbors.get(edge[0]).add(edge[1]);
      neighbors.get(edge[1]).add(edge[0]);
    }
    int cnt = 0;
    for (int i = 0; i < n ; i++) {
      if (!visited[i]) {
        cnt += 1;
        dfs(visited, i, neighbors);
      }
    }
    return cnt;
  }

  public void dfs(boolean[] visited, int index, List<List<Integer>> neighbors) {
    if (index >= visited.length) {
      return;
    }
    if (visited[index]) {
      return;
    }
    visited[index] = true;

    for (int neighbor : neighbors.get(index)) {
      dfs(visited, neighbor, neighbors);
    }
    return;
  }
}