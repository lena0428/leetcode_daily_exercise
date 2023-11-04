package d_stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-parentheses/description/
 * @author: Yidan
 * @create: 2023-10-23 17:38
 **/

public class Solution20 {
  public boolean isValid(String s) {
    Stack<Character> parentheses = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '['  || s.charAt(i) == '{' ) {
        parentheses.push(s.charAt(i));
      } else {
        if (parentheses.isEmpty()) {
          return false;
        }
        char pop = parentheses.pop();
        if (pop == '(' && s.charAt(i) != ')') {
          return false;
        } else if (pop == '[' && s.charAt(i) != ']') {
          return false;
        } else if (pop == '{' && s.charAt(i) != '}') {
          return false;
        }
      }
    }
    return parentheses.isEmpty();
  }
}