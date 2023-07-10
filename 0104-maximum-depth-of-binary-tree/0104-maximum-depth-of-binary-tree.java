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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (isLeaf(root)) {
            return 1;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}