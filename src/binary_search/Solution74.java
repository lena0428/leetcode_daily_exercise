package binary_search;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/search-a-2d-matrix/
 * @author: Yidan
 * @create: 2023-10-23 19:58
 **/

public class Solution74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int i = 0;
    int j = matrix[0].length - 1;
    while (i < matrix[0].length && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        i++;
      } else {
        j--;
      }
    }
    return false;
  }
}