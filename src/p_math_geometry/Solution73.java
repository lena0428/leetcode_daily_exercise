package p_math_geometry;

/**
 * @program: leetcode_daily_exercise
 * @description: https://leetcode.com/problems/set-matrix-zeroes/description/
 * @author: Yidan
 * @create: 2024-01-06 21:48
 **/

public class Solution73 {
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    boolean firstRowHasZero = false;
    boolean firstColHasZero = false;

    // Check if first row has zero
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        firstRowHasZero = true;
        break;
      }
    }

    // Check if first column has zero
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        firstColHasZero = true;
        break;
      }
    }

    // Mark zeros in first row and first column
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    // Set zeros based on marks in first row and first column
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // Set zeros in first row if needed
    if (firstRowHasZero) {
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = 0;
      }
    }

    // Set zeros in first column if needed
    if (firstColHasZero) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}