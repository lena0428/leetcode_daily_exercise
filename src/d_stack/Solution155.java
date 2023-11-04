package d_stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/min-stack/description/
 * @author: Yidan
 * @create: 2023-10-23 19:41
 **/

public class Solution155 {
  class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }

    public void push(int val) {
      stack.push(val);
      if (!minStack.isEmpty()) {
        int min = minStack.peek();
        if (min > val) {
          min = val;
        }
        minStack.push(min);
      } else {
        minStack.push(val);
      }
    }

    public void pop() {
      stack.pop();
      minStack.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return minStack.peek();
    }
  }
}