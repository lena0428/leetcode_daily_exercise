package i_heap_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/find-median-from-data-stream/description/
 * @author: Yidan
 * @create: 2023-11-20 17:23
 **/

public class Solution295 {
  class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
      maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2) {
          return i2 - i1;
        }
      });
      minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
      maxHeap.offer(num);
      // make sure every element in maxHeap is smaller half, every element in min Heap in bigger half
      if (maxHeap.size() != 0 && minHeap.size() != 0 && maxHeap.peek() > minHeap.peek()) {
        minHeap.offer(maxHeap.poll());
      }
      // make balance
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.offer(maxHeap.poll());
      }
      if (maxHeap.size() + 1 < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
    }

    public double findMedian() {
      if (maxHeap.size() > minHeap.size()) {
        return maxHeap.peek();
      }
      if (maxHeap.size() < minHeap.size()) {
        return minHeap.peek();
      }
      return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
    }
  }

  /**
   * Your MedianFinder object will be instantiated and called as such:
   * MedianFinder obj = new MedianFinder();
   * obj.addNum(num);
   * double param_2 = obj.findMedian();
   */
}