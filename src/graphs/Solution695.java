package graphs;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/max-area-of-island/description/
 * @author: Yidan
 * @create: 2023-10-29 16:09
 **/

public class Solution695 {
  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          int cnt = dfs(grid, visited, i, j);
          max = Math.max(max, cnt);
        }
      }
    }
    return max;
  }

  public int dfs(int[][] grid, boolean[][] visited, int x, int y) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
      return 0;
    }
    if (visited[x][y]) {
      return 0;
    }
    if (grid[x][y] == 0) {
      return 0;
    }
    visited[x][y] = true;
    return 1 + dfs(grid, visited, x - 1, y) + dfs(grid, visited, x + 1, y) + dfs(grid, visited, x, y + 1) + dfs(grid, visited, x, y - 1);
  }
}