package g_trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * @author: Yidan
 * @create: 2023-11-17 20:47
 **/
public class Solution297 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // level traversal
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#";
    }
    StringBuilder res = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur == null) {
        res.append("#,");
        continue;
      }
      res.append(cur.val + ",");
      queue.offer(cur.left);
      queue.offer(cur.right);
    }
    return res.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (("#").equals(data)) {
      return null;
    }
    String[] nodes = data.split(",");
    TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
    int index = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty() && index < nodes.length) {
      TreeNode cur = queue.poll();
      if (!("#").equals(nodes[index])) {
        TreeNode left = new TreeNode(Integer.valueOf(nodes[index]));
        cur.left = left;
        queue.offer(left);
      }
      index++;
      if (index < nodes.length && !("#").equals(nodes[index])) {
        TreeNode right = new TreeNode(Integer.valueOf(nodes[index]));
        cur.right = right;
        queue.offer(right);
      }
      index++;
    }
    return root;
  }
}