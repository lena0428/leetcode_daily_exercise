package h_tries;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/word-search-ii/description/
 * @author: Yidan
 * @create: 2023-11-19 15:22
 **/

public class Solution212 {
  class TrieNode {
    TrieNode[] children;
    boolean endOfTheWord;

    TrieNode() {
      this.children = new TrieNode[26];
      this.endOfTheWord = false;
    }

  }

  public void addWord(TrieNode root, String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new TrieNode();
      }
      cur = cur.children[c - 'a'];
    }
    cur.endOfTheWord = true;
  }

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      addWord(root, word);
    }
    List<String> res = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(res, root, board, new boolean[board.length][board[0].length], i, j, "");
      }
    }
    return res;
  }

  public void dfs(List<String> res, TrieNode root, char[][] board, boolean[][] visited, int x, int y, String word) {
    if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
      return;
    }
    if (visited[x][y]) {
      return;
    }
    if (root.children[board[x][y] - 'a'] == null) {
      return;
    }
    visited[x][y] = true;
    root = root.children[board[x][y] - 'a'];
    word += board[x][y];
    if (root.endOfTheWord) {
      res.add(word);
      // avoid duplicate words in the result, and continue to explore new word
      root.endOfTheWord = false;
    }
    dfs(res, root, board, visited, x - 1, y, word);
    dfs(res, root, board, visited, x + 1, y, word);
    dfs(res, root, board, visited, x, y - 1, word);
    dfs(res, root, board, visited, x, y + 1, word);
    // backtrack
    visited[x][y] = false;
    word = word.substring(0, word.length() - 1);
  }
}