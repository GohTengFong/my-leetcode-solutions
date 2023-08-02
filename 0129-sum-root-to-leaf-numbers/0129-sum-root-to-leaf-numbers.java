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

    private int dfs(TreeNode node, int currSum) {
        if (isLeaf(node)) return currSum * 10 + node.val;

        int totalSum = 0;
        int newCurrSum = (currSum == 0 ? node.val : currSum * 10 + node.val);

        if (node.left != null) totalSum += dfs(node.left, newCurrSum);
        if (node.right != null) totalSum += dfs(node.right, newCurrSum);

        return totalSum;
    }

    public int sumNumbers(TreeNode root) {
        if (isLeaf(root)) return root.val;

        return dfs(root, 0);
    }
}