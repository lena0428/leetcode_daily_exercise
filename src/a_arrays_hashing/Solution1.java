package a_arrays_hashing;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/two-sum/description/
 * @author: Yidan
 * @create: 2023-10-21 17:28
 **/

public class Solution1 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[] { map.get(target - nums[i]), i };
      }
      map.put(nums[i], i);
    }
    return new int[] { -1, -1 };
  }
}