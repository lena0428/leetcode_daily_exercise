package p_math_geometry;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/plus-one/description/
 * @author: Yidan
 * @create: 2023-10-30 19:00
 **/

public class Solution66 {
  public int[] plusOne(int[] digits) {
    digits[digits.length - 1] += 1;
    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      carry = sum / 10;
      digits[i] = sum % 10;
    }
    if (carry != 0) {
      int[] res = new int[digits.length + 1];
      res[0] = 1;
      for (int i = 0; i < digits.length; i++) {
        res[i + 1] = digits[i];
      }
      return res;
    } else {
      return digits;
    }
  }
}