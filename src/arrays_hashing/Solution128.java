package arrays_hashing;

import java.util.HashSet;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/longest-consecutive-sequence/description/
 * @author: Yidan
 * @create: 2023-10-21 20:46
 **/

public class Solution128 {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int maxLength = 0;
    for (int num : nums) {
      if (set.contains(num - 1)) {
        continue;
      }
      int tmp = num;
      int length = 0;
      while (set.contains(tmp)) {
        tmp++;
        length++;
      }
      maxLength = Math.max(maxLength, length);
    }
    return maxLength;
  }
}