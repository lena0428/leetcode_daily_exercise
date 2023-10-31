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
    HashSet<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      neighbors.add(new ArrayList<>());
    }
    for (int[] edge: edges) {
      neighbors.get(edge[0]).add(edge[1]);
      neighbors.get(edge[1]).add(edge[0]);
    }
    return dfs(0, -1, visited, neighbors) && visited.size() == n;
  }

  public boolean dfs(int cur, int prev, HashSet<Integer> visited, List<List<Integer>> neighbors) {
    // the current point was visited, the graph has a loop.
    if (visited.contains(cur)) {
      return false;
    }
    // visit current point
    visited.add(cur);
    List<Integer> neighborList = neighbors.get(cur);
    for (int neighbor: neighborList) {
      // just parent node, does not mean there is a loop.
      if (prev == neighbor) {
        continue;
      }
      if (visited.contains(neighbor)) {
        return false;
      }
      if (!dfs(neighbor, cur, visited, neighbors)) {
        return false;
      }
    }
    return true;
  }
}