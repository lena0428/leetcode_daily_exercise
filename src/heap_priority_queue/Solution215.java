package heap_priority_queue;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * @author: Yidan
 * @create: 2023-10-30 16:55
 **/

public class Solution215 {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int num: nums) {
      queue.offer(num);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    return queue.peek();
  }
}