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
    int maxSum = Integer.MIN_VALUE;

    // returns the max path sum where the highest node is the input node
    private int recurse(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, recurse(node.left));
        int right = Math.max(0, recurse(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        recurse(root);

        return maxSum;
    }
}

/*

Idea :
- a maximum path goes up the tree then down the tree
- each path has a highest node
- for all nodes in the graph, treat it as the highest node
- find the max path upwards (up from left)
- find the max path downwards (down to right)
- current path sum = left + right + node.val
- update maxSum if current path sum > maxSum

*/