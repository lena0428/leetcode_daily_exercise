package trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/subtree-of-another-tree/description/
 * @author: Yidan
 * @create: 2023-10-28 22:15
 **/

public class Solution572 {

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
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root == null && subRoot != null) {
      return false;
    }
    if (root != null && subRoot == null) {
      return true;
    }
    if (isSameTree(root, subRoot)) {
      return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean isSameTree(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return true;
    }
    if (t1 != null && t2 == null) {
      return false;
    }
    if (t1 == null && t2 != null) {
      return false;
    }
    return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
  }
}