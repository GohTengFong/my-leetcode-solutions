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
    public int maxLength = 0;

    public void dfs(TreeNode root, int prevDir, int currLength) {
        if (root == null) return;

        maxLength = Math.max(maxLength, currLength);

        if (prevDir == 1) { // came from right
            dfs(root.left, 0, currLength + 1); // add one to currLength when going left
            dfs(root.right, 1, 1); // currLength resets to 0 since not zigzag
        } else {
            dfs(root.right, 1, currLength + 1);
            dfs(root.left, 0, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0); // prevDir = 0 represents going left
        dfs(root, 1, 0); // prevDir = 1 represents going right

        return maxLength;
    }
}