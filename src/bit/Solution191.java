package bit;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/number-of-1-bits/description/
 * @author: Yidan
 * @create: 2023-10-30 22:35
 **/

public class Solution191 {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int cnt = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        cnt++;
      }
      n >>>= 1;
    }
    return cnt;
  }
}