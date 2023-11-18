package g_trees;

/**
  @program: leetcode
  @description: https://leetcode.com/problems/binary-tree-maximum-path-sum/
  @author: Yidan
  @create: 2023-11-17 22:26
 */

public class Solution124 {
  
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  /**
   * The binary tree can have various paths, and the maximum path
   * sum might not be directly connected to the root node.
   * This line ensures that the algorithm considers all potential paths,
   * updating maxSum whenever a higher path sum is found. It captures
   * the global maximum among all paths.
   */
  int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    calculateMaxPathSum(root);
    return maxSum;
  }

  private int calculateMaxPathSum(TreeNode node) {
    if (node == null) {
      return 0;
    }

    // Calculate max sum from left and right subtrees
    int leftSum = Math.max(0, calculateMaxPathSum(node.left));
    int rightSum = Math.max(0, calculateMaxPathSum(node.right));

    // Update the maximum path sum found so far
    maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

    // Return the maximum sum achievable by including the current node in the path
    return Math.max(leftSum, rightSum) + node.val;
  }
}