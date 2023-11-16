package d_stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
 * @author: Yidan
 * @create: 2023-11-16 14:23
 **/

public class Solution84 {
  class Item {
    int height;
    int index;
    Item(int height, int index) {
      this.height = height;
      this.index = index;
    }
  }
  public int largestRectangleArea(int[] heights) {
    Stack<Item> stack = new Stack<>();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      // left extend
      int start = i;
      // stack peek cannot extend anymore
      while (!stack.isEmpty() && stack.peek().height > heights[i]) {
        Item pop = stack.pop();
        max = Math.max(max, pop.height * (i - pop.index));
        start = pop.index;
      }
      stack.push(new Item(heights[i], start));
    }
    // calculate the item that can cover the whole width of histogram
    while (!stack.isEmpty()) {
      Item pop = stack.pop();
      max = Math.max(max, pop.height * (heights.length - pop.index));
    }
    return max;
  }
}