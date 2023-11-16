package d_stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/min-stack/description/
 * @author: Yidan
 * @create: 2023-11-15 19:37
 **/

public class Solution155 {
  class MinStack {
    class Item {
      private int minValue;
      private int curValue;

      Item(int minValue, int curValue) {
        this.minValue = minValue;
        this.curValue = curValue;
      }

      public int getMinValue() {
        return this.minValue;
      }

      public int getCurValue() {
        return this.curValue;
      }
    }

    Stack<Item> stack;

    public MinStack() {
      stack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(new Item(val, val));
      } else {
        int curMin = stack.peek().getMinValue();
        stack.push(new Item(Math.min(curMin, val), val));
      }
    }

    public void pop() {
      if (!stack.isEmpty()) {
        stack.pop();
      }
    }

    public int top() {
      return stack.peek().getCurValue();
    }

    public int getMin() {
      return stack.peek().getMinValue();
    }
  }

  /**
   * Your MinStack object will be instantiated and called as such:
   * MinStack obj = new MinStack();
   * obj.push(val);
   * obj.pop();
   * int param_3 = obj.top();
   * int param_4 = obj.getMin();
   */
}