package g_trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/diameter-of-binary-tree/description/
 * @author: Yidan
 * @create: 2023-11-17 15:35
 **/

public class Solution543 {
  /**
   *       1
   *     2   3
   *   4  5
   * 6      7
   *
   * like this tree, the diameter may not pass through the root
   */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public int diameterOfBinaryTree(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = depth(root.left);
      int right = depth(root.right);
      // compare contain root and not contain root
      return Math.max(Math.max(left + right, diameterOfBinaryTree(root.left)),
          diameterOfBinaryTree(root.right));
    }

    public int depth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = depth(root.left) + 1;
      int right = depth(root.right) + 1;
      return Math.max(left, right);
    }
  }
}