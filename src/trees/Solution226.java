package trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/invert-binary-tree/
 * @author: Yidan
 * @create: 2023-10-28 21:22
 **/

public class Solution226 {
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
  // DFS
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  /**
   *     // bfs
   *     public int maxDepth(TreeNode root) {
   *         if (root == null) {
   *             return 0;
   *         }
   *         int level = 0;
   *         // linkedlist
   *         Queue<TreeNode> queue = new LinkedList<>();
   *         queue.offer(root);
   *         while (!queue.isEmpty()) {
   *             int size = queue.size();
   *             level++;
   *             for (int i = 0; i < size; i ++) {
   *                 TreeNode tmp = queue.poll();
   *                 if (tmp.left != null) {
   *                     queue.offer(tmp.left);
   *                 }
   *                 if (tmp.right != null) {
   *                     queue.offer(tmp.right);
   *                 }
   *             }
   *         }
   *         return level;
   *     }
   */
}