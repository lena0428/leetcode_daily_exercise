package m_dp2d;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/unique-paths/description/
 * @author: Yidan
 * @create: 2023-10-30 22:28
 **/

public class Solution62 {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = 1;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
}