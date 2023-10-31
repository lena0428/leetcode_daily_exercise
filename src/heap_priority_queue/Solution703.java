package heap_priority_queue;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * @author: Yidan
 * @create: 2023-10-30 16:51
 **/

public class Solution703 {
  class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int size;

    public KthLargest(int k, int[] nums) {
      this.size = k;
      for (int i = 0; i < nums.length; i++) {
        this.add(nums[i]);
      }
    }

    public int add(int val) {
      queue.offer(val);
      if (queue.size() > size) {
        queue.poll();
      }
      return queue.peek();
    }
  }

  /**
   * Your KthLargest object will be instantiated and called as such:
   * KthLargest obj = new KthLargest(k, nums);
   * int param_1 = obj.add(val);
   */
}