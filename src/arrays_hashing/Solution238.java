package arrays_hashing;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/product-of-array-except-self/
 * @author: Yidan
 * @create: 2023-10-21 18:14
 **/

public class Solution238 {
  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int prefix = 1;
    Arrays.fill(res, 1);
    for (int i = 0; i < nums.length; i++) {
      res[i] = prefix;
      prefix *= nums[i];
    }
    int postfix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= postfix;
      postfix *= nums[i];
    }
    return res;
  }
}