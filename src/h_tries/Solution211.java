package h_tries;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 * @author: Yidan
 * @create: 2023-11-18 19:31
 **/

public class Solution211 {
  class WordDictionary {
    class TrieNode {
      TrieNode[] children;
      boolean endOfTheWord;

      TrieNode() {
        children = new TrieNode[26];
        endOfTheWord = false;
      }
    }

    private TrieNode root;

    public WordDictionary() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode();
        }
        cur = cur.children[c - 'a'];
      }
      cur.endOfTheWord = true;
    }

    public boolean search(String word) {
      return searchWord(word, 0, root);
    }

    private boolean searchWord(String word, int index, TrieNode root) {
      if (index == word.length()) {
        return root.endOfTheWord;
      }
      char c = word.charAt(index);
      // skip it
      if (c == '.') {
        for (TrieNode children : root.children) {
          if (children != null && searchWord(word, index + 1, children)) {
            return true;
          }
        }
        return false;
      } else {
        TrieNode child = root.children[c - 'a'];
        return child != null && searchWord(word, index + 1, child);
      }
    }
  }

  /**
   * Your WordDictionary object will be instantiated and called as such:
   * WordDictionary obj = new WordDictionary();
   * obj.addWord(word);
   * boolean param_2 = obj.search(word);
   */
}