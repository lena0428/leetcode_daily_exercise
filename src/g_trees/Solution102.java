package g_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * @author: Yidan
 * @create: 2023-10-28 22:35
 **/

public class Solution102 {
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
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> tmpList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode tmp = queue.poll();
        tmpList.add(tmp.val);
        if (tmp.left != null) {
          queue.offer(tmp.left);
        }
        if (tmp.right != null) {
          queue.offer(tmp.right);
        }
      }
      res.add(tmpList);
    }
    return res;
  }
}