package d_stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/daily-temperatures/
 * @author: Yidan
 * @create: 2023-11-15 18:34
 **/

public class Solution739 {
  class Item {
    private int temperature;
    private int index;

    Item (int temperature, int index) {
      this.temperature = temperature;
      this.index = index;
    }

    public int getTemperature() {
      return this.temperature;
    }

    public int getIndex() {
      return this.index;
    }
  }
  public int[] dailyTemperatures(int[] temperatures) {
    // eg. 1 2 3 4
    // 1 1 1 0
    //
    // eg. 1 0 0 0 4
    // 1 0 0 0 (4)
    // 4 3 2 1
    int[] res = new int[temperatures.length];

    Stack<Item> stack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > stack.peek().getTemperature()) {
        Item pop = stack.pop();
        res[pop.getIndex()] = i - pop.getIndex();
      }
      stack.push(new Item(temperatures[i], i));
    }
    return res;
  }
}