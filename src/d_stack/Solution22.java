package d_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/generate-parentheses/
 * @author: Yidan
 * @create: 2023-11-15 19:17
 **/

public class Solution22 {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtrack(0, 0, n, new StringBuilder(), res);
    return res;
  }

  public void backtrack(int openCount, int closeCount, int n, StringBuilder str, List<String> res) {
    if (openCount == n && closeCount == n) {
      res.add(str.toString());
      return;
    }
    if (openCount < n) {
      str.append("(");
      backtrack(openCount + 1, closeCount, n, str, res);
      str.deleteCharAt(str.length() - 1);
    }
    if (openCount > closeCount) {
      str.append(")");
      backtrack(openCount, closeCount + 1, n, str, res);
      str.deleteCharAt(str.length() - 1);
    }
  }
}