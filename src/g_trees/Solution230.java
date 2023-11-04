package g_trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * @author: Yidan
 * @create: 2023-10-29 19:05
 **/

public class Solution230 {
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

    int cnt = 0;
    int value = 0;

    public int kthSmallest(TreeNode root, int k) {
      kth(root, k);
      return value;
    }

    public void kth(TreeNode root, int k) {
      if (root == null) {
        return;
      }
      kth(root.left, k);
      cnt++;
      if (cnt == k) {
        value = root.val;
      }
      kth(root.right, k);
    }
  }
}