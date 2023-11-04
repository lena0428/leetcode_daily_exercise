package m_dp2d;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * @author: Yidan
 * @create: 2023-10-23 16:29
 **/

/**
 * using dynamic programming:
 *
 * Consider whether to buy or not:
 *
 * If you buy on the current day, the profit is 0 - prices[i].
 * If you don't buy today, the profit remains unchanged.
 * Consider whether to sell or not:
 *
 * If you sell on the current day, the profit increases by prices[i].
 * If you don't sell today, the profit remains unchanged.
 *
 * Define dp[i][0/1], where dp[i][0] represents the maximum profit up
 * to the i-th day without holding the stock, and dp[i][1] represents
 * the maximum profit with holding the stock. Then:
 *
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]). The second term
 * represents the state of holding on the i-1 day and selling on the i-th day.
 * dp[i][1] = max(dp[i-1][1], 0 - prices[i]). The second term represents
 * the state of buying on the i-th day (initial profit is 0 because you
 * can make at most 1 transaction).
 * Termination condition: dp[n-1][0], where n is the total number of days.
 * The maximum profit without holding the stock at the end will be the final result.
 *
 * This approach allows you to calculate the maximum profit for a given
 * stock price sequence while considering when to buy and when to sell to
 * maximize your profit.
 */
public class Solution121 {
  public int maxProfit(int[] prices) {
    // [1] represents buy [0] represents sell
    int[][] dp = new int[prices.length][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      // single day
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
    }
    return dp[prices.length - 1][0];
  }
}