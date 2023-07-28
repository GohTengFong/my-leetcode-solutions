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
        if (node.left == null && node.right == null) return true;

        return false;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        else if (root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        else if (val > root.val) return searchBST(root.right, val);

        return null;
    }
}