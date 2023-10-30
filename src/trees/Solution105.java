package trees;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * @author: Yidan
 * @create: 2023-10-29 19:26
 **/

public class Solution105 {
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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(null, preorder, 0, preorder.length - 1, inorder, 0 , inorder.length - 1);
  }

  public TreeNode build(TreeNode root, int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
    // base case
    if (preLeft > preRight) {
      return null;
    }
    root = new TreeNode(preorder[preLeft]);
    int index = 0;
    for (index = inLeft; index <= inRight; index++) {
      if (inorder[index] == preorder[preLeft]) {
        break;
      }
    }
    root.left = build(root.left, preorder, preLeft + 1, preLeft + index - inLeft, inorder, inLeft, index - 1);
    root.right = build(root.right, preorder, preLeft + index - inLeft + 1, preRight, inorder, index + 1, inRight);
    return root;
  }
}