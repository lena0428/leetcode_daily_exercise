package d_stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * @author: Yidan
 * @create: 2023-10-23 17:59
 **/

public class Solution150 {
  public int evalRPN(String[] tokens) {
    Stack<Integer> digitStack = new Stack<>();
    for (String token: tokens) {
      if (Character.isDigit(token.charAt(0)) || token.length() > 1) {
        Integer i = Integer.valueOf(token);
        digitStack.push(i);
      } else {
        int right = digitStack.pop();
        int left = digitStack.pop();
        if ("+".equals(token)) {
          digitStack.push(left + right);
        } else if ("-".equals(token)) {
          digitStack.push(left - right);
        } else if ("/".equals(token)) {
          digitStack.push(left / right);
        } else if ("*".equals(token)) {
          digitStack.push(left * right);
        }
      }
    }
    return digitStack.pop();
  }
}