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
        if (node.left == null && node.right == null) {
            return true;
        }

        return false;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left != null && isLeaf(node.left)) {
            return node.left.val + traverse(node.right);    
        } else {
            return traverse(node.left) + traverse(node.right);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (isLeaf(root) || root == null) {
            return 0;
        } else if (root.left != null && isLeaf(root.left)) {
            return root.left.val + traverse(root.right);
        }

        return traverse(root.left) + traverse(root.right);
    }
}