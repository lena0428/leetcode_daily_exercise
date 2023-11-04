package k_graphs;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/number-of-islands/description/
 * @author: Yidan
 * @create: 2023-10-29 11:43
 **/

public class Solution200 {
  public int numIslands(char[][] grid) {
    int cnt = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          cnt++;
        }
      }
    }
    return cnt;
  }

  public void dfs(char[][] grid, int x, int y) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
      return;
    }
    if (grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';
    dfs(grid, x - 1, y);
    dfs(grid, x, y - 1);
    dfs(grid, x + 1, y);
    dfs(grid, x, y + 1);
  }
}