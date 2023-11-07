package j_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * @author: Yidan
 * @create: 2023-11-06 22:28
 **/

public class Solution17 {
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0){
      return new ArrayList<>();
    }
    String[] alphabetics = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    dfs(res, path, alphabetics, digits, 0);
    return res;
  }

  public void dfs(List<String> res, StringBuilder path, String[] alphabetics, String digits, int index) {
    if (index == digits.length()) {
      res.add(new String(path));
      return;
    }
    int k = digits.charAt(index) - '0';
    String s = alphabetics[k];
    for (int i = 0; i < s.length(); i++) {
      // decide to add this alphabetic
      path.append(s.charAt(i));
      dfs(res, path, alphabetics, digits, index + 1);
      // decide not to add this alphabetic
      path.deleteCharAt(path.length() - 1);
    }
  }
}