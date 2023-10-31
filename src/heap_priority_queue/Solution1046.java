package heap_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/last-stone-weight/description/
 * @author: Yidan
 * @create: 2023-10-30 17:31
 **/

public class Solution1046 {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1);
      }
    });
    for (int stone: stones) {
      queue.offer(stone);
    }
    while (true) {
      int left = 0;
      int right = 0;
      if (queue.size() >= 1) {
        left = queue.poll();
      }
      if (queue.size() >= 1) {
        right = queue.poll();
      }
      queue.offer(Math.abs(left - right));
      if (queue.size() == 1) {
        break;
      }
    }
    return queue.peek();
  }
}