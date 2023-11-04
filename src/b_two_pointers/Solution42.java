package b_two_pointers;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/trapping-rain-water/description/
 * @author: Yidan
 * @create: 2023-11-03 18:05
 **/

public class Solution42 {
  public int trap(int[] height) {
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    int[] minLeftAndRight = new int[height.length];

    // 1. find leftMax
    int leftM = 0;
    for (int i = 0; i < height.length; i++) {
      leftMax[i] = leftM;
      if (leftM < height[i]) {
        leftM = height[i];
      }
    }
    // 2. find rightMax
    int rightM = 0;
    for (int i = height.length - 1; i >= 0; i--) {
      rightMax[i] = rightM;
      if (rightM < height[i]) {
        rightM = height[i];
      }
    }
    // 3. calculate water
    int res = 0;
    for (int i = 0; i < height.length; i++) {
      res += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
    }
    return res;
  }
}