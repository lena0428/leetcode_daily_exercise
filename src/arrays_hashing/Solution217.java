package arrays_hashing;

import java.util.HashSet;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/contains-duplicate/description/
 * @author: Yidan
 * @create: 2023-10-21 16:59
 **/

public class Solution217 {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (set.contains(i)) {
        return true;
      }
      set.add(i);
    }
    return false;
  }
}