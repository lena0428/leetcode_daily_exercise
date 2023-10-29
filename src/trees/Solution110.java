package trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/balanced-binary-tree/description/
 * @author: Yidan
 * @create: 2023-10-28 21:57
 **/
public class Solution110 {

  class TreeNode {
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
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public int treeDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = treeDepth(root.left);
    int right = treeDepth(root.right);
    return left > right ? (1 + left) : (1 + right);
  }
}