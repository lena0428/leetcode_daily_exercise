package a_arrays_hashing;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-sudoku/description/
 * @author: Yidan
 * @create: 2023-10-21 21:13
 **/

public class Solution36 {
  public boolean isValidSudoku(char[][] board) {
    // Check columns
    for (int i = 0; i < 9; i++) {
      boolean[] existed = new boolean[10];
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        if (existed[board[i][j] - '0']) {
          return false;
        }
        existed[board[i][j] - '0'] = true;
      }
    }

    // Check rows
    for (int j = 0; j < 9; j++) {
      boolean[] existed = new boolean[10];
      for (int i = 0; i < 9; i++) {
        if (board[i][j] == '.') {
          continue;
        }
        if (existed[board[i][j] - '0']) {
          return false;
        }
        existed[board[i][j] - '0'] = true;
      }
    }

    // Check 3x3 subgrids
    for (int k = 0; k < 3; k++) {
      for (int l = 0; l < 3; l++) {
        boolean[] existed = new boolean[10];
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            if (board[k * 3 + i][l * 3 + j] == '.') {
              continue;
            }
            if (existed[board[k * 3 + i][l * 3 + j] - '0']) {
              return false;
            }
            existed[board[k * 3 + i][l * 3 + j] - '0'] = true;
          }
        }
      }
    }
    return true;
  }
}