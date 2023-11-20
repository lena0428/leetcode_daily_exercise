package n_greedy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/jump-game/description/
 * @author: Yidan
 * @create: 2023-11-19 17:30
 **/

public class Solution55 {
  public boolean canJump(int[] nums) {
    int maxReachable = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxReachable) {
        return false;
      }
      maxReachable = Math.max(maxReachable, i + nums[i]);
      if (maxReachable >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }
}