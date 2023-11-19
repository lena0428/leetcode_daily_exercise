package j_backtracking;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/word-search/
 * @author: Yidan
 * @create: 2023-11-18 21:24
 **/

public class Solution79 {
  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (dfs(board, new boolean[rows][cols], word, 0, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(char[][] board, boolean[][] visited, String word, int index, int x, int y) {
    if (index == word.length()) {
      return true;
    }
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
      return false;
    }
    if (visited[x][y]) {
      return false;
    }
    if (word.charAt(index) != board[x][y]) {
      return false;
    }
    visited[x][y] = true;
    boolean valid = dfs(board, visited, word, index + 1, x - 1, y) || dfs(board, visited, word,
        index + 1, x + 1, y) || dfs(board, visited, word, index + 1, x, y - 1) || dfs(board,
        visited, word, index + 1, x, y + 1);
    if (valid) {
      return true;
    } else {
      visited[x][y] = false;
      return false;
    }
  }
}