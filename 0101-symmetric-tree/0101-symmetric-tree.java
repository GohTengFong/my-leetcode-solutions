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

    private boolean compareSubTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null && node2 != null) {
            return false;
        } else if (node1 != null && node2 == null) {
            return false;
        }
        
        if (node1.val != node2.val) {
            return false;
        } else {
            return compareSubTrees(node1.left, node2.right) && compareSubTrees(node1.right, node2.left);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return true;
        } else {
            return compareSubTrees(root.left, root.right);
        }
    }
}