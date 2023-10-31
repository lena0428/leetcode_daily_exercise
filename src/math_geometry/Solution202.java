package math_geometry;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/happy-number/
 * @author: Yidan
 * @create: 2023-10-30 19:00
 **/

public class Solution202 {
  public boolean isHappy(int n) {
    int fast = n;
    int slow = n;
    while (true) {
      fast = sumOfSquaresOfDigits(sumOfSquaresOfDigits(fast));
      slow = sumOfSquaresOfDigits(slow);
      if (fast == slow) {
        break;
      }
    }
    return fast == 1;
  }

  public int sumOfSquaresOfDigits(int n) {
    int res = 0;
    while (n != 0) {
      res += Math.pow(n % 10, 2);
      n /= 10;
    }
    return res;
  }
}