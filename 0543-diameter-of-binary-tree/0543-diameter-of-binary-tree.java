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

    private int heightOfTree(TreeNode node) {
        if (node == null || isLeaf(node)) {
            return 0;
        } else {
            return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return 1 + heightOfTree(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + heightOfTree(root.left);
        } else {
            int leftHeight = 1 + heightOfTree(root.left);
            int rightHeight = 1 + heightOfTree(root.right);
            int currMax = leftHeight + rightHeight;

            int leftSubTree = diameterOfBinaryTree(root.left);
            int rightSubTree = diameterOfBinaryTree(root.right);

            if (leftSubTree > currMax) {
                return leftSubTree;
            } else if (rightSubTree > currMax) {
                return rightSubTree;
            }

            return currMax;
        }
    }
}