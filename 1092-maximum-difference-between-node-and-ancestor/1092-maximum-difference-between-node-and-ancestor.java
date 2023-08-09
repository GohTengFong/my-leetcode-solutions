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
    private int searchMax(TreeNode node, int currMax) {
        int newMax = (node.val > currMax ? node.val : currMax);

        if (node.left != null) {
            newMax = Math.max(newMax, searchMax(node.left, newMax));
        }
        
        if (node.right != null) {
            newMax = Math.max(newMax, searchMax(node.right, newMax));
        }

        return newMax;
    }

    private int searchMin(TreeNode node, int currMin) {
        int newMin = (node.val < currMin ? node.val : currMin);

        if (node.left != null) {
            newMin = Math.min(newMin, searchMin(node.left, newMin));
        }

        if (node.right != null) {
            newMin = Math.min(newMin, searchMin(node.right, newMin));
        }

        return newMin;
    }

    public int maxAncestorDiff(TreeNode root) {
        int minVal = searchMin(root, root.val);
        int maxVal = searchMax(root, root.val);

        int diffWithMin = Math.abs(root.val - minVal);
        int diffWithMax = Math.abs(root.val - maxVal);

        int max = (diffWithMin > diffWithMax ? diffWithMin : diffWithMax);

        if (root.left != null) {
            max = Math.max(max, maxAncestorDiff(root.left));
        }

        if (root.right != null) {
            max = Math.max(max, maxAncestorDiff(root.right));
        }

        return max;
    }
}