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

    private int dfs(TreeNode node, int currMax) {
        if (isLeaf(node) && node.val >= currMax) return 1;

        int newMax = Math.max(currMax, node.val);
        int count = 0;

        if (node.left != null) count += dfs(node.left, newMax);

        if (node.val >= currMax) count += 1;

        if (node.right != null) count += dfs(node.right, newMax);

        return count;
    }

    public int goodNodes(TreeNode root) {
        if (isLeaf(root)) return 1;

        return dfs(root, root.val);
    }
}