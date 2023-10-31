package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://www.lintcode.com/problem/178/
 * @author: Yidan
 * @create: 2023-10-31 13:21
 **/

public class Solution261 {
  /**
   * @param n: An integer
   * @param edges: a list of undirected edges
   * @return: true if it's a valid tree, or false
   */
  public boolean validTree(int n, int[][] edges) {
    // write your code here
    if (n == 0) {
      return true;
    }
    List<List<Integer>> neighbors = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      neighbors.add(new ArrayList<>());
    }
    HashSet<Integer> visited = new HashSet<>();
    for (int[] edge: edges) {
      neighbors.get(edge[0]).add(edge[1]);
      neighbors.get(edge[1]).add(edge[0]);
    }
    // each point can connect with each other, and use dfs (will not visit twice)
    return dfs(0, -1, visited, neighbors) && visited.size() == n;
  }

  public boolean dfs(int cur, int prev, HashSet<Integer> visited, List<List<Integer>> neighbors) {
    if (visited.contains(cur)) {
      return false;
    }
    visited.add(cur);
    List<Integer> neighbor = neighbors.get(cur);
    for (int i: neighbor) {
      if (i == prev) {
        continue;
      }
      if (visited.contains(i)) {
        return false;
      }
      if (!dfs(i, cur, visited, neighbors)) {
        return false;
      }
    }
    return true;
  }
}