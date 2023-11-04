package a_arrays_hashing;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/product-of-array-except-self/
 * @author: Yidan
 * @create: 2023-10-21 18:14
 **/

public class Solution238 {
  public int[] productExceptSelf(int[] nums) {
    //       1 2 3 4
    //prefix     1 1 2 2*3
    //postfix   2*3*4 3*4 4 1
    int prefix = 1;
    int postfix = 1;
    int[] res = new int[nums.length];
    Arrays.fill(res, 1);
    for (int i = 0; i < nums.length; i++) {
      res[i] = prefix;
      prefix *= nums[i];
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= postfix;
      postfix *= nums[i];
    }
    return res;
  }
}