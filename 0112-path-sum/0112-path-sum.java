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

    private boolean dfs(TreeNode node, int target, int currSum) {
        if (isLeaf(node) && currSum + node.val == target) return true;
        else if (isLeaf(node) && currSum + node.val != target) return false;

        if (node.left != null && node.right == null) return dfs(node.left, target, currSum + node.val);
        else if (node.right != null && node.left == null) return dfs(node.right, target, currSum + node.val);
        else return dfs(node.left, target, currSum + node.val) || dfs(node.right, target, currSum + node.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        return dfs(root, targetSum, 0);
    }
}