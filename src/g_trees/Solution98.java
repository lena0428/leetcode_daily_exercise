package g_trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/validate-binary-search-tree/description/
 * @author: Yidan
 * @create: 2023-10-29 18:49
 **/

public class Solution98 {
   public class TreeNode {
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
  boolean first = true;
  int min = 0;
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean left = isValidBST(root.left);
    // check the first node
    if (first) {
      first = false;
    } else {
      if (min >= root.val) {
        return false;
      }
    }
    min = root.val;
    boolean right = isValidBST(root.right);
    return left && right;
  }
}