package two_pointers;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/container-with-most-water/description/
 * @author: Yidan
 * @create: 2023-10-22 19:47
 **/

public class Solution11 {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left < right) {
      max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }
}