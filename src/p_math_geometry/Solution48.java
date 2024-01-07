package p_math_geometry;

/**
 * @program: leetcode_daily_exercise
 * @description: https://leetcode.com/problems/rotate-image/description/
 * @author: Yidan
 * @create: 2024-01-06 21:49
 **/

public class Solution48 {

  public void rotate(int[][] matrix) {
    // Transpose the matrix
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j <= i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }

    // Reverse each row horizontally to get the clockwise rotated matrix
    for (int i = 0; i < matrix.length; i++) {
      int left = 0;
      int right = matrix[0].length - 1;
      while (left <= right) {
        int tmp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = tmp;
        left++;
        right--;
      }
    }
  }

}