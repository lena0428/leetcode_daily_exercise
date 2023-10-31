package heap_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/k-closest-points-to-origin/
 * @author: Yidan
 * @create: 2023-10-30 18:04
 **/

public class Solution973 {
  class Pointer {
    int x;
    int y;

    Pointer(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Pointer> queue = new PriorityQueue<>(new Comparator<Pointer>() {
      public int compare(Pointer p1, Pointer p2) {
        double distance1 = Math.pow(Math.pow(p1.x, 2) + Math.pow(p1.y, 2), 1.0 / 2);
        double distance2 = Math.pow(Math.pow(p2.x, 2) + Math.pow(p2.y, 2), 1.0 / 2);
        if (distance1 - distance2 > 0) {
          return -1;
        } else if (distance1 == distance2) {
          return 0;
        } else {
          return 1;
        }
      }
    });
    for (int[] point : points) {
      queue.offer(new Pointer(point[0], point[1]));
      if (queue.size() > k) {
        queue.poll();
      }
    }
    int[][] res = new int[k][2];
    int index = 0;
    while (!queue.isEmpty()) {
      Pointer tmp = queue.poll();
      res[index][0] = tmp.x;
      res[index++][1] = tmp.y;
    }
    return res;
  }
}