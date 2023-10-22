package arrays_hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/top-k-frequent-elements/
 * @author: Yidan
 * @create: 2023-10-21 20:19
 **/

public class Solution347 {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
      if (frequencyMap.containsKey(num)) {
        int frequency = frequencyMap.get(num);
        frequency++;
        frequencyMap.put(num, frequency);
      } else {
        frequencyMap.put(num, 1);
      }
    }
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
        new Comparator<Map.Entry<Integer, Integer>>() {
          @Override public int compare(Map.Entry<Integer, Integer> e1,
              Map.Entry<Integer, Integer> e2) {
            return e1.getValue() - e2.getValue();
          }
        });
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      queue.offer(entry);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    int[] res = new int[queue.size()];
    int index = 0;
    while (!queue.isEmpty()) {
      res[index++] = queue.poll().getKey();
    }
    return res;
  }
}