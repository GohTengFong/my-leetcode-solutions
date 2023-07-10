/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean isLeaf(TreeNode node) {
        if (node.right == null && node.left == null) {
            return true;
        }

        return false;
    }

    private void swapChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return root;
        } else {
            invertTree(root.right);
            invertTree(root.left);
            swapChildren(root);
            return root;
        }
    }
}