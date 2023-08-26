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
    private int getSum(TreeNode root, int targetSum, long sum) {
        int res = 0;

        if (root == null) return res;
        
        sum += root.val;
        
        if (sum == targetSum) res++;
        
        res += getSum(root.left, targetSum, sum);
        res += getSum(root.right, targetSum, sum);
        
        return res;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        return getSum(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
}