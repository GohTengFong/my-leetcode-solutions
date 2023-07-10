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

    private int getHeight(TreeNode node) {
        if (isLeaf(node)) {
            return 0;        
        } else if (node.left == null && node.right != null) {
            return 1 + getHeight(node.right);
        } else if (node.right == null && node.left != null) {
            return 1 + getHeight(node.left);
        } else {
            return Math.max(1 + getHeight(node.right), 1 + getHeight(node.left));
        }
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return true;
        } else if (root.left == null && root.right != null) {
            int rightHeight = getHeight(root.right);

            if (1 + rightHeight > 1) {
                return false;
            }
        } else if (root.right == null && root.left != null) {
            int leftHeight = getHeight(root.left);

            if (1 + leftHeight > 1) {
                return false;
            }
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if (leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1) {
                return false;
            }
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}