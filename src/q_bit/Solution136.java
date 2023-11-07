package q_bit;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/single-number/description/
 * @author: Yidan
 * @create: 2023-11-05 21:04
 **/

public class Solution136 {
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int num: nums) {
      res ^= num;
    }
    return res;
  }
}