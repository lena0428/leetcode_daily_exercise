package sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/sliding-window-maximum/
 * @author: Yidan
 * @create: 2023-10-20 23:32
 **/

class Solution239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // 1 1 1 1 1 3 3 k =6
    Deque<Integer> queue = new ArrayDeque<>();
    int left = 0;
    int right = 0;
    int[] res = new int[nums.length - k + 1];
    int index = 0;
    while (right < nums.length) {
      while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
        queue.pollLast();
      }
      queue.offerLast(right);
      if (left > queue.peekFirst()) {
        queue.pollFirst();
      }
      if (right + 1 >= k) {
        res[index++] = nums[queue.peekFirst()];
        left++;
      }
      right++;
    }
    return res;
  }
}